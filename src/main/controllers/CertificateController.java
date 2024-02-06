
package main.controllers;
import main.models.User;
import main.models.Course;

public class CertificateController {
    private User usuario;
    private Course curso;
    private String date;
    public CertificateController(User usuario, Course curso, String date){
        this.usuario = usuario;
        this.curso = curso;
        this.date = date;
    }
    
    public String getCourse(){
        return curso.getName();
    }
    
    public User getData(){
        return usuario;
    }
    
    public String getDate(){
        return this.date;
    }
}
