
package main.controllers;

import java.util.ArrayList;
import java.util.List;
import main.models.Exam;
import main.models.Question;
import main.models.Answer;
import main.models.User;

public class TakeExamController {
    private Exam examen;
    private List<Boolean> respuesta;
    private int hour;
    private int minute;
    private int second;
    private float result;
    private User usuario;
    
    public TakeExamController(Exam examen,User usuario){
        this.examen = examen;
        respuesta = new ArrayList<>();
        hour=0;
        second=0;
        minute=0;
        result = 0;
        for(int i=0;i<getQuestNumber();i++){
            for(int j=0;j<getIterator(i);j++)
                if(getRightAnswer(i,j)==true)
                    result++;
        }
        getTime();
        
        
        
    }
    
    public int gethour(){
        return hour;
    }
    public int getminute(){
        return minute;
    }
    public int getsecond(){
        return second;
    }
    
    private void getTime(){
        float minuteTime = examen.getMinuteTime();
        
        if(minuteTime<60&&minuteTime>=1)
            minute = (int)minuteTime;
            
        
        if(minuteTime>=60){
            minuteTime/=60;
           hour = (int) minuteTime;
           minuteTime = minuteTime - (float)hour;
           minute = (int)(minuteTime*60);
        }
        
        
        
    }
    
    public int ansNumber(){
        int k=0;
        for(int i=0;i<respuesta.size();i++){
            if(respuesta.get(i)!=null)
                k++;
        }
        return k;
    }
    
    public int getIterator(int i){
        return examen.getAnswerNumber(i);
    }
    
    public void setRespuesta(boolean respuesta, int i){
        this.respuesta.add(i, respuesta);
    }
    
     public void setRespuesta(boolean respuesta){
        this.respuesta.add(respuesta);
    }
    
    public boolean getRespuesta(int i){
        return respuesta.get(i);
    }
    
    public String getStatement(int i){
        return examen.getPreguntas(i).getStatement();
    }
    
    public boolean getRightAnswer(int i, int j){
        return this.examen.getPreguntas(i).getAnswer(j).isRight();
    }
    
    public int getQuestNumber(){
        return examen.getQuestionNumber();
    }
    
    public String getTextAnswer(int i, int j){
        return examen.getPreguntas(i).getAnswer(j).getText();
    }
    
    public int getRespuestaSize(){
        return respuesta.size();
    }
     public String getJustiication(int index){
        return examen.getPreguntas(index).getJustification();
    }
    public float getResult(){
        return result;
    }
    
    public User getUsuario(){
        return this.usuario;
    }
}
    
