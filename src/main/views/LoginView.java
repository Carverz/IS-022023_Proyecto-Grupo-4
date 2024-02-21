package main.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import main.controllers.HomeController;
import main.controllers.CredentialsController;
import main.models.User;

public class LoginView extends JFrame {
    private JTextField mailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Inicio de Sesion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("Logo.png");
        setIconImage(image.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(150, 400, 150, 400));
        panel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 10);

        JLabel mailLabel = new JLabel("Correo:");
        mailLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
        formPanel.add(mailLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mailField = new JTextField();
        mailField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(mailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;

        JLabel passwordLabel = new JLabel("Contrasena:");
        passwordLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);

        loginButton = new JButton("Iniciar Sesion");
        loginButton.setBackground(new Color(0x2271B3));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = mailField.getText();
                String password = new String(passwordField.getPassword());
                String name = "";
                CredentialsController check = new CredentialsController();
                int[] cursos = {0,1,2,-1,-1,-1,-1,-1,-1};
                User usuario = new User("Luis",mail,password,cursos);
                
                HomeController homeController = new HomeController(usuario);

                if (check.checkCredentials(mail, password, name)) {
                    //System.out.println("Inicio de sesión exitoso");
                    System.out.println("Nombre: " + name);
                    HomeView homeView = new HomeView(homeController);
                    homeView.setVisible(true);
                    dispose(); // Cierra la ventana actual de inicio de sesión
                } else {
                    //System.out.println("Credenciales inválidas. Por favor, inténtalo de nuevo.");
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas. Por favor, inténtalo de nuevo.");
                }
            }
        });

        buttonPanel.add(loginButton);
        formPanel.setBorder(BorderFactory.createEmptyBorder(100,30,0,30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 100, 30));

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(true);
    }

}