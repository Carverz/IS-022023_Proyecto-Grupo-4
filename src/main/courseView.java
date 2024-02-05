package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class courseView extends JFrame {
    
    public courseView(User user, courseController controller) {

        setTitle("Perfil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton profileButton = new JButton("Perfil");
        JButton logoutButton = new JButton("Cerrar Sesion");
        JButton homeButton = new JButton("Inicio");
        JButton helpButton = new JButton("Ayuda!!!");
        topPanel.setBackground(Color.white);
        topPanel.setForeground(Color.black);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userView UserView = new userView(user);
                UserView.setVisible(true);
                dispose(); 
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logOut LogOut = new logOut();
                LogOut.setVisible(true);
                dispose(); 
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeView HomeView = new homeView();
                HomeView.setVisible(true);
                dispose(); 
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpView HelpView = new helpView(user);
                HelpView.setVisible(true);
                dispose(); 
            }
        });

        // Agregar botones al panel superior
        topPanel.add(profileButton, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);
        topPanel.add(homeButton, BorderLayout.CENTER);
        topPanel.add(helpButton, BorderLayout.SOUTH);

        // Agregar panel superior al JFrame
        add(topPanel, BorderLayout.NORTH);

        // Mostrar la información del curso
        Course course = controller.getCourse();
        JPanel courseInfoPanel = new JPanel();
        courseInfoPanel.setLayout(new BoxLayout(courseInfoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(course.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        courseInfoPanel.add(nameLabel);

        JTextArea descriptionArea = new JTextArea(course.getDescription());
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setPreferredSize(new Dimension(250, 150));
        courseInfoPanel.add(descriptionScrollPane);

        // Agregar panel de información del curso a la izquierda
        add(courseInfoPanel, BorderLayout.CENTER);

        // Mostrar la imagen del curso
        JLabel imageLabel = new JLabel(new ImageIcon(course.getImage()));
        add(imageLabel, BorderLayout.EAST);

        // Agregar botón "Ver exámenes" debajo de la imagen del curso
        JButton viewExamsButton = new JButton("Ver exámenes");
        viewExamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examsView ExamsView = new examsView(user, controller);
                ExamsView.setVisible(true);
                dispose(); 
            }
        });
        JPanel examsButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        examsButtonPanel.add(viewExamsButton);
        add(examsButtonPanel, BorderLayout.SOUTH);
    }
}
