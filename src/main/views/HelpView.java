package main.views;

import javax.swing.*;
import main.controllers.HomeController;
import main.controllers.ProfileController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpView extends JFrame {

    public HelpView(HomeController controller) {


        setTitle("Ayuda!!!");
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
                ProfileController profileController = new ProfileController(controller.usuario);
                ProfileView profileView = new ProfileView(profileController);
                profileView.setVisible(true);
                dispose(); 
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogOutView LogOut = new LogOutView(HelpView.this);
                LogOut.setVisible(true);
                dispose();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView homeView = new HomeView(controller);
                homeView.setVisible(true);
                dispose(); 
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpView helpView = new HelpView(controller);
                helpView.setVisible(true);
                dispose(); 
            }
        });
    }
}