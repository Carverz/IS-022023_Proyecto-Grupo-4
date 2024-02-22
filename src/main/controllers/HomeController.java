
package main.controllers;
import main.models.Course;
import main.models.User;
import main.models.Answer;
import main.models.Question;
import main.models.Exam;
import java.util.ArrayList;
import java.util.List;

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
            ArrayList<Answer> respuesta = new ArrayList<>();
            respuesta.add(new Answer("5",false));
            respuesta.add(new Answer("6",false));
            respuesta.add(new Answer("4",false));
            respuesta.add(new Answer("7",false));
            respuesta.add(new Answer("8",false));

            ArrayList<Question> pregunta = new ArrayList<>();
            pregunta.add(new Question("¿Cuanto es 2 + 2?",respuesta,"2 + 2 = 4","Algebra"));

            Exam examen = new Exam(pregunta,120,name);
            examController = new TakeExamController(examen,usuario);
            return examController;
        }
        return null;
    }
    
  
}
