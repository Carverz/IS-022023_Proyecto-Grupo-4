package main;
import javax.swing.*;

import main.views.LoginView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginView();
            }
        });
    }
}