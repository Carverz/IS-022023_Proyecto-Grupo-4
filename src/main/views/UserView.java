package main.views;
//package main.Views;

import javax.swing.*;

import main.views.LogOut;
import main.models.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserView extends JFrame {

    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JTextField usernameField;
    private JTextField emailField;
    private JLabel userImageLabel;

    public UserView(User user) {

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

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel userInfoPanel = new JPanel(new GridLayout(5, 2));
        usernameLabel = new JLabel("Nombre:");
        emailLabel = new JLabel("Correo:");
        centerPanel.setBackground(Color.white);
        centerPanel.setForeground(Color.black);
        userInfoPanel.setBackground(Color.white);
        userInfoPanel.setForeground(Color.black);

        JPanel usernamePanel = new JPanel();
        usernamePanel.setPreferredSize(new Dimension(350, 200));
        usernameField = new JTextField(30);
        usernamePanel.setBackground(Color.white);
        usernamePanel.setForeground(Color.black);

        JPanel emailPanel = new JPanel();
        emailPanel.setPreferredSize(new Dimension(350, 200));
        emailField = new JTextField(30);
        emailPanel.setBackground(Color.white);
        emailPanel.setForeground(Color.black);

        userImageLabel = new JLabel(); 

        JPanel messagePanel = new JPanel(new GridLayout(6, 2));
        messagePanel.add(usernameLabel);
        messagePanel.add(emailLabel);
        messagePanel.setBackground(Color.white);
        messagePanel.setForeground(Color.black);

        usernamePanel.add(usernameField);
        emailPanel.add(emailField);
        userInfoPanel.add(usernamePanel);
        userInfoPanel.add(emailPanel);

        centerPanel.add(userImageLabel, BorderLayout.WEST);
        centerPanel.add(messagePanel, BorderLayout.CENTER);
        centerPanel.add(userInfoPanel, BorderLayout.EAST);

        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));
        emailLabel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        addCertificateButtons();

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserView userView = new UserView(user);
                userView.setVisible(true);
                dispose(); 
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LogOut logOut = new LogOut();
                logOut.setVisible(true);
                dispose(); 
            }
        });
/* 
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                HomeView homeView = new HomeView();
                HomeViewomeView.setVisible(true);
                dispose(); 
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HelpView helpView = new HelpView(user);
                helpView.setVisible(true);
                dispose(); 
            }
        });*/

        ImageIcon icon = new ImageIcon("C:\\Users\\cezav\\OneDrive\\Escritorio\\IS-022023_Proyecto-Grupo-4\\src\\JavaTech_logo.jpg");
        Image iconImage = icon.getImage();
        setIconImage(iconImage);

 
        setUsername(user.getName());
        setEmail(user.getMail());
    }


    public void setUsername(String username) {
        usernameField.setText(username);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public void setEmail(String email) {
        emailField.setText(email);
    }

    public String getEmail() {
        return emailField.getText();
    }

    private void addCertificateButtons() {

        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("01/01/2023 - Curso: Base de datos");
        certificates.add("05/03/2023 - Curso: Java Basico");
        certificates.add("10/07/2023 - Curso: C++ Basico");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.white);
        bottomPanel.setForeground(Color.black);
        for (String certificate : certificates) {
            JButton certificateButton = new JButton(certificate);
            bottomPanel.add(certificateButton);
        }
        add(bottomPanel, BorderLayout.SOUTH);
    }
}