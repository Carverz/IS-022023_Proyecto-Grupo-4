package main.views;
import javax.swing.*;
import main.controllers.HomeController;
import main.controllers.ProfileController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpView extends JFrame {

    private ProfileController Controller;

    public HelpView(HomeController controller) {
        this.Controller = new ProfileController(controller.usuario);
        setTitle("Ayuda!!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton profileButton = new JButton("Perfil");
        JButton logoutButton = new JButton("Cerrar Sesion");
        JButton homeButton = new JButton("Inicio");
        JButton helpButton = new JButton("Ayuda!!!");
        topPanel.setBackground(Color.white);
        topPanel.setForeground(Color.black);

        JPanel leftButtonPanel = new JPanel(new GridLayout(1, 2));
        leftButtonPanel.add(homeButton);
        leftButtonPanel.add(helpButton);
        leftButtonPanel.setBackground(Color.white);
        leftButtonPanel.setForeground(Color.black);

        JPanel rightButtonPanel = new JPanel(new GridLayout(1, 2));
        rightButtonPanel.add(profileButton);
        rightButtonPanel.add(logoutButton);
        rightButtonPanel.setBackground(Color.white);
        rightButtonPanel.setForeground(Color.black);

        topPanel.add(leftButtonPanel, BorderLayout.WEST);
        topPanel.add(rightButtonPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH); 

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfileView profileView = new ProfileView(Controller);
                profileView.setVisible(true);
                dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogOutView logOut = new LogOutView(HelpView.this);
                logOut.setVisible(true);
                dispose();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeController homeController = new HomeController(controller.usuario);
                HomeView homeView = new HomeView(homeController);
                homeView.setVisible(true);
                dispose();
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.white);
        optionsPanel.setForeground(Color.black);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS)); 
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        Font questionFont = new Font("Arial", Font.BOLD, 20); 

        JLabel option1Label = new JLabel("<html><span style='font-size:20px; color:blue;'>¿Cómo puedo ver mi perfil?</span><br/><span style='font-size:16px;'>Haz clic en el botón de la parte superior (Perfil)</span></html>");
        option1Label.setFont(questionFont);

        JLabel option2Label = new JLabel("<html><span style='font-size:20px; color:blue;'>¿Cómo puedo ver mis certificados obtenidos?</span><br/><span style='font-size:16px;'>Puedes ver tus certificados obtenidos en la pantalla de Perfil</span></html>");
        option2Label.setFont(questionFont);

        JLabel option3Label = new JLabel("<html><span style='font-size:20px; color:blue;'>¿Cuánto dura cada examen?</span><br/><span style='font-size:16px;'>Normalmente la duración de los exámenes es de 1 hora, sin embargo esto puede variar, por lo cual debes estar atento a las instrucciones del docente</span></html>");
        option3Label.setFont(questionFont);

        JLabel option4Label = new JLabel("<html><span style='font-size:20px; color:blue;'>¿Puedo regresar a preguntas anteriores durante un examen?</span><br/><span style='font-size:16px;'>Sí, puedes regresar a preguntas anteriores durante un examen ya que el movimiento entre preguntas es libre</span></html>");
        option4Label.setFont(questionFont);

        JLabel option5Label = new JLabel("<html><span style='font-size:20px; color:blue;'>¿Cuál es la nota mínima aprobatoria para un examen?</span><br/><span style='font-size:16px;'>La nota mínima aprobatoria es de 10 puntos, siendo 20 puntos la nota máxima posible</span></html>");
        option5Label.setFont(questionFont);

        optionsPanel.add(option1Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        optionsPanel.add(option2Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        optionsPanel.add(option3Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        optionsPanel.add(option4Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        optionsPanel.add(option5Label);

        add(optionsPanel, BorderLayout.CENTER);
    }
}