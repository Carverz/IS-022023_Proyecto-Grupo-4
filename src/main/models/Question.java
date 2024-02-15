
package main.models;
import java.util.ArrayList;
import java.util.List;
import main.models.Answer;

public class Question {
    private String statement;
    private ArrayList<Answer> respuesta;
    private String justification;
    
    public Question(String statement,ArrayList<Answer> respuesta,String justification){
        this.statement = statement;
        this.respuesta = respuesta;
        this.justification = justification;
    }
    
    public Question(String statement, ArrayList<Answer> respuesta){
        this.statement = statement;
        this.respuesta = respuesta;
    }
    
    public String getStatement(){
        return statement;
    }
    
    public int getAnswerNumber(){
        return this.respuesta.size();
    }
    
    public Answer getAnswer(int i){
        return this.respuesta.get(i);
    }
}
