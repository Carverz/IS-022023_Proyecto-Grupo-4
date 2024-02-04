package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class courseView extends JFrame {
    public courseView(User user) {
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

            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar la lógica para la acción del botón "Inicio" aquí
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar la lógica para la acción del botón "Ayuda!!!" aquí
            }
        });

        topPanel.add(profileButton, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);
        topPanel.add(homeButton, BorderLayout.CENTER);
        topPanel.add(helpButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
    }
}