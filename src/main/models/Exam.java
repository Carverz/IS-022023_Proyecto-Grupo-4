
package main.models;
import java.util.ArrayList;
import main.models.Question;
import main.models.Answer;

public class Exam {
    private ArrayList<Question> preguntas;
    private int result;
    private int minuteTime;

    
    
    public Exam(ArrayList<Question> preguntas,int minuteTime){
        this.preguntas = preguntas;
        this.result = 0;
        this.minuteTime = minuteTime;
    }
    
    public Question getPreguntas(int i){
        return preguntas.get(i);
    }
    
      public void increaseResult(){
        this.result++;
    }
    
    public int getResult(){
        return this.result;
    }
    
    public int getQuestionNumber(){
        return this.preguntas.size();
    }
    
    public int getAnswerNumber(int i){
        return this.preguntas.get(i).getAnswerNumber();
    }
    
    public int getMinuteTime(){
        return this.minuteTime;
    }
}


