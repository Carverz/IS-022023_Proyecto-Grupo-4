//package main.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class credentialsController{

    public boolean checkCredentials(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Credenciales.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}