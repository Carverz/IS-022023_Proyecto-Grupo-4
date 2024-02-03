import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {

    public UserInterface() {
        // Configuración del marco principal
        setTitle("Interfaz de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());

        // Panel para los botones en la parte superior
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton profileButton = new JButton("Perfil");
        JButton logoutButton = new JButton("Log Out");
        topPanel.add(profileButton);
        topPanel.add(logoutButton);

        // Panel para el nombre de usuario y los botones de Inicio y Ayuda
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        JLabel usernameLabel = new JLabel("Nombre de Usuario");
        JButton homeButton = new JButton("Inicio");
        JButton helpButton = new JButton("Ayuda!!!");
        centerPanel.add(usernameLabel);
        centerPanel.add(homeButton);
        centerPanel.add(helpButton);

        // Agregar los paneles al marco principal
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // Acción del botón de Perfil
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes colocar el código para abrir la misma interfaz de usuario
                // Suponiendo que "ui" es el nombre del objeto de la interfaz
                // ui.setVisible(true);
            }
        });

        // Acción del botón de Log Out
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes colocar el código para cerrar la aplicación
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la interfaz de usuario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }
}