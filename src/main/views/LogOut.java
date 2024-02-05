package main.views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.LoginView;

public class LogOut extends JFrame {

    public LogOut() {
        setTitle("Cerrar Sesión");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel messageLabel = new JLabel("¿Deseas cerrar sesión?");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(messageLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        
        JButton yesButton = new JButton("Sí");
        yesButton.setBackground(Color.RED);
        yesButton.setForeground(Color.WHITE);
        yesButton.setFont(new Font("Arial", Font.BOLD, 14));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar sesión y regresar a la pantalla de inicio de sesión
                dispose(); // Cierra la ventana actual
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new LoginView();
                    }
                });
            }
        });
        buttonPanel.add(yesButton);
        
        JButton noButton = new JButton("No");
        noButton.setBackground(Color.WHITE);
        noButton.setFont(new Font("Arial", Font.PLAIN, 14));
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar solo la ventana de cerrar sesión
                dispose(); // Cierra la ventana actual
            }
        });
        buttonPanel.add(noButton);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        getContentPane().add(panel);
        
        setVisible(true);
    }
}