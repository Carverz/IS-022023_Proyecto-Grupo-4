package main;
//package main.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CredentialsController{

    public boolean checkCredentials(String username, String password, boolean admin) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Credenciales.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 3 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    if(credentials[2].equals("admin")){
                        admin = true;
                    }
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