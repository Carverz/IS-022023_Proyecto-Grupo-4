package main.controllers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import main.models.Course;
import main.models.User;
import main.controllers.HomeController;

public class CredentialsController{
    
    private HomeController controller;

    public boolean checkCredentials(String username, String password) {
        try {
            InputStream in =this.getClass().getResourceAsStream("Credenciales.txt");
            Reader re = new InputStreamReader(in,"utf-8");
            BufferedReader reader = new BufferedReader(re);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    reader.close();
                    int[] num ={0,1,2,-1,-1,-1,-1,-1,-1};
                
                User usuar = new User("CARLOS EDUARDO ZAVARCE VELASQUEZ","EMAIL","ZARVACE",num);
                    
                    this.controller =new HomeController(usuar);
                    return true;
                    
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("false");
        return false;
    }
    
    public HomeController getHomeController(){
        return this.controller;
    }
    
}