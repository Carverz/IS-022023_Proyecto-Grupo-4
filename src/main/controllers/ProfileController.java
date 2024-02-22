package main.controllers;
import main.models.User;

public class ProfileController {
    public User usuario;

    
    public ProfileController(User usuario){
        this.usuario = usuario;
    }
    

    
    public String getUserName() {
        return usuario.getName();
    }
    
    public String getUserMail() {
        return usuario.getMail();
    }
}
