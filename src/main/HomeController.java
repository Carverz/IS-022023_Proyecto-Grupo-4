
package main;
import main.User;
//import main.models.Course;

public class HomeController {
    private User usuario;
    private Course[] curso;
    
    public HomeController(User usuario){
        this.usuario = usuario;
        this.curso = new Course[3];
                curso[0] = new Course("Lenguaje de Programación Java: Nivel Basico");
                curso[1] = new Course("Lenguaje de Programación C++: Nivel Basico");
                curso[2] = new Course("Lenguaje de Programación PHP: Nivel Basico");
    }
    
    public String getName(int i){
        if(usuario.getCourseData()[i]<0)
            return null;
        return curso[usuario.getCourseData()[i]].getName();
    }
}
