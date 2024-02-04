
package main;
import Course;
import User;

public class HomeController {
    private User usuario;
    private Course[] curso;
    
    public HomeController(User usuario, Course[] curso){
        this.usuario = usuario;
       this.curso = curso;
    }
    
    public String getName(int i){
        if(usuario.getCourseData()[i]<0)
            return null;
        return curso[usuario.getCourseData()[i]].getName();
    }
}
