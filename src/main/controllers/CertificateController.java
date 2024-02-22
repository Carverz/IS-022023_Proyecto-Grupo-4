
package main.controllers;
import main.models.User;


public class CertificateController {
    private User usuario;

    private String date;
    public CertificateController(User usuario, String date){
        this.usuario = usuario;

        this.date = date;
    }

    
    public User getData(){
        return usuario;
    }
    
    public String getDate(){
        return this.date;
    }
}
