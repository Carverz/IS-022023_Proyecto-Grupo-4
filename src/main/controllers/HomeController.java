
package main.controllers;

import main.models.User;
import main.models.Answer;
import main.models.Question;
import main.models.Exam;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    public User usuario;

    private TakeExamController examController;
    
    public HomeController(User usuario){
        this.usuario = usuario;
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
            examController = new TakeExamController(examen);
            return examController;
        }
        return null;
    }
    
  
}
