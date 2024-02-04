//package main.Controllers;

//import Models.User;
//import Models.Course;

public class RequestCertificateController {
    private User usuario;
    private Course curso;
    private String date;
    public RequestCertificateController(User usuario, Course curso, String date){
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
