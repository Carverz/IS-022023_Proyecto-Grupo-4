
package main.controllers;
import main.models.Course;
import main.models.User;
import main.models.Answer;
import main.models.Question;
import main.models.Exam;

public class HomeController {
    public User usuario;
    private Course[] curso;
    private TakeExamController examController;
    
    public HomeController(User usuario){
        this.usuario = usuario;
        this.curso = new Course[3];
                curso[0] = new Course("Lenguaje de Programación Java: Nivel Basico");
                curso[1] = new Course("Lenguaje de Programación C++: Nivel Basico");
                curso[2] = new Course("Lenguaje de Programación PHP: Nivel Basico");
    }

    public TakeExamController getExamController(String name){
        if(name=="Exam1"){
            
            
        }
        
    }
    
  
}
