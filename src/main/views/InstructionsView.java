package main.views;

import javax.swing.*;
import main.controllers.HomeController;
import main.controllers.ProfileController;
import main.controllers.TakeExamController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsView extends JFrame {

    private ProfileController Controller;
    private TakeExamController examController;
    private String exam;

    public InstructionsView(HomeController controller,String exam) {
        this.Controller = new ProfileController(controller.usuario);
        this.exam = exam;
        
        setTitle("Instrucciones");
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

        add(topPanel, BorderLayout.NORTH); // Agrega topPanel al contenedor principal

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
                LogOutView logOut = new LogOutView(InstructionsView.this);
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
                // Implementa la lógica para mostrar el texto de ayuda
            }
        });

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.white);
        optionsPanel.setForeground(Color.black);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS)); // Orientación vertical
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añade un espacio alrededor del panel

        Font questionFont = new Font("Arial", Font.BOLD, 20); // Fuente y tamaño del texto para las preguntas

        JLabel option1Label = new JLabel("<html><span style='font-size:20px; color:black;'>1- El examen tendrá una duración de 1 hora, si se termina el tiempo, el examen finalizará con las preguntas respondidas hasta ese momento.\n </span></html>");
        option1Label.setFont(questionFont);

        JLabel option2Label = new JLabel("<html><span style='font-size:20px; color:black;'>2- Lea las preguntas detenidamente para poder comprender lo solicitado en el enunciado.\n </span></html>");
        option2Label.setFont(questionFont);

        JLabel option3Label = new JLabel("<html><span style='font-size:20px; color:black;'>3- El objetivo de este examen es medir los conocimientos y habilidades adquiridas por usted durante la realización de este curso.\n </span></html>");
        option3Label.setFont(questionFont);

        JLabel option4Label = new JLabel("<html><span style='font-size:20px; color:black;'>4- El examen es totalmente individual, cualquier intento de copia o plagio será penalizado con la nota mínima (01).</span></html>");
        option4Label.setFont(questionFont);

        optionsPanel.add(option1Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añade espacio entre las preguntas
        optionsPanel.add(option2Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añade espacio entre las preguntas
        optionsPanel.add(option3Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añade espacio entre las preguntas
        optionsPanel.add(option4Label);
        optionsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añade espacio entre las preguntas

        add(optionsPanel, BorderLayout.CENTER); // Agrega optionsPanel al centro del contenedor principal

        // Crea el botón "Aceptar"
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.setFont(new Font("Arial", Font.BOLD, 24)); // Ajusta el tamaño de la fuente del botón

        // Crea un panel para contener el botón "Aceptar"
        JPanel acceptButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Utiliza FlowLayout para centrar el botón
        acceptButtonPanel.setBackground(Color.white);
        acceptButtonPanel.add(acceptButton);

        // Agrega el panel del botón "Aceptar" al contenedor principal debajo del panel de opciones
        add(acceptButtonPanel, BorderLayout.SOUTH);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                examController = controller.getExamController(exam);
                ExamView view = new ExamView(examController,0);
                dispose();
                // Lógica para manejar el clic en el botón "Aceptar"
            }
        });
    }
}
