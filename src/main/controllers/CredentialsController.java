package main.controllers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CredentialsController{
    public boolean checkCredentials(String correo, String contrasenia) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Credenciales.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split("/");
                if (datos.length == 2 && datos[0].equals(correo) && datos[1].equals(contrasenia)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}