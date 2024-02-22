package main.views;

import main.models.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class AddUserView extends JFrame {
    private JTextField userTextField;
    private JTextField passwordTextField;
    private JTextField nameTextField;
    private JTextArea passwordTextArea;
    private JTextArea userTextArea;
    private JTextArea nameTextArea;
    private JButton addUser;

    public AddUserView() {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Configuración de la interfaz de usuario
        setLocationRelativeTo(null);
        setTitle("Anadir Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel userLabel = new JLabel("Introduzca el correo del usuario: ");
        JLabel nameLabel = new JLabel("Nombre del usuario: ");

        JLabel passwordLabel = new JLabel("Introduzca la clave del usuario: ");

        userTextArea = new JTextArea();
        passwordTextArea = new JTextArea();
        nameTextArea = new JTextArea();

        // JScrollPane userScrollPane = new JScrollPane(userTextArea);

        addUser = new JButton("Agregar Usuario");

        inputPanel.add(userLabel);
        inputPanel.add(userTextField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordTextField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        // inputPanel.add(userScrollPane);
        inputPanel.add(addUser);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JTextArea usersTextArea = new JTextArea();
        usersTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(usersTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userTextArea.getText().isEmpty() || passwordTextArea.getText().isEmpty()
                        || nameTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la información.", "Campo obligatorio",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    String userText = userTextArea.getText();
                    String passwordText = passwordTextArea.getText();
                    String nameText = nameTextArea.getText();

                    // Mostrar las preguntas en el área de texto
                    usersTextArea.append("Nombre Usuario: " + nameText + "\n");
                    usersTextArea.append("Correo: " + userText + "\n");
                    usersTextArea.append("Contrasena: " + passwordText + "\n");
                    usersTextArea.append("\n");


                    JSONParser parser = new JSONParser();

                    try (FileReader reader = new FileReader("src\\data\\Datos.json")) {
                        Object obj = parser.parse(reader);
                        JSONObject jsonObject = (JSONObject) obj;
                        JSONArray array = (JSONArray) jsonObject.get("Datos");
        
                        JSONObject newUser = new JSONObject();
                        newUser.put("name", nameText);
                        newUser.put("mail", userText);
                        newUser.put("password", passwordText);
                        array.add(newUser);
        
                        try (FileWriter file = new FileWriter("src\\data\\Datos.json")) {
                            file.write(jsonObject.toJSONString());
                            file.flush();
                        }
        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    // Limpiar los campos de texto
                    passwordTextField.setText("");
                    userTextArea.setText("");
                }
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddUserView();
    }
}