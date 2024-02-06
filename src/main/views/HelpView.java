package main.views;

import javax.swing.*;

import main.controllers.HomeController;

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
        topPanel.setBackground(Color.white);
        topPanel.setForeground(Color.black);

        JButton profileButton = new JButton("Perfil");
        JButton logoutButton = new JButton("Cerrar Sesion");
        JButton homeButton = new JButton("Inicio");
        JButton helpButton = new JButton("Ayuda!!!");
        

        // Agregar ActionListener para cada botón
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la acción del botón Perfil
                System.out.println("Botón Perfil presionado");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la acción del botón Cerrar Sesión
                System.out.println("Botón Cerrar Sesión presionado");
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la acción del botón Inicio
                System.out.println("Botón Inicio presionado");
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la acción del botón Ayuda
                System.out.println("Botón Ayuda presionado");
            }
        });

        // Agregar los botones al panel superior (topPanel)
        topPanel.add(profileButton, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);
        topPanel.add(homeButton, BorderLayout.CENTER);
        topPanel.add(helpButton, BorderLayout.SOUTH);

        // Agregar el panel superior al marco principal (this)
        add(topPanel, BorderLayout.NORTH);

        // Resto de tu código...
    }

    // Otros métodos y miembros de la clase aquí...
}