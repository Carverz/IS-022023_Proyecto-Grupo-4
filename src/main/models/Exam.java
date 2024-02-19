package main.models;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Exam {
    private String name;
    private ArrayList<Question> preguntas;
    private int result;
    private int minuteTime;

    
    
    public Exam(ArrayList<Question> preguntas,int minuteTime, String name){
        this.preguntas = preguntas;
        this.result = 0;
        this.minuteTime = minuteTime;
        this.name = name;
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

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject examJSON = new JSONObject();
        examJSON.put("name", this.name);
        examJSON.put("duration", this.minuteTime);
        JSONArray questionsArray = new JSONArray();
        questionsArray.addAll(this.preguntas.stream().map(Question::toJSON).collect(Collectors.toList()));
        examJSON.put("questions", questionsArray);
        return examJSON;
    }  
}


