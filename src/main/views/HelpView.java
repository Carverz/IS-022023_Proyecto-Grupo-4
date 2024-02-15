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
                LogOutView LogOut = new LogOutView(HelpView.this);
                LogOut.setVisible(true);
                dispose(); 
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
                HelpView helpView = new HelpView(controller);
                helpView.setVisible(true);
                dispose(); 
            }
        });

        
    }
}
