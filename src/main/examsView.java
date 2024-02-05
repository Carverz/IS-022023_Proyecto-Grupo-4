/* 
package main;


import main.views.UserView;


import main.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamsView extends JFrame {
        private ExamsController controller;

        public ExamsView(User user, ExamsController controller) {
        this.controller = controller;

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

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView homeView = new HomeView();
                homeView.setVisible(true);
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
        });

        topPanel.add(profileButton, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);
        topPanel.add(homeButton, BorderLayout.CENTER);
        topPanel.add(helpButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

       // Crear botones para los exámenes
       Exam[] exams = controller.getExams();
       JPanel examsPanel = new JPanel(new GridLayout(exams.length, 1));
       for (Exam exam : exams) {
           JButton examButton = new JButton(exam.getName());
           examButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   // Lógica para el botón del examen si es necesario
               }
           });
           examsPanel.add(examButton);
       }
       add(examsPanel, BorderLayout.CENTER);
   }
}
*/