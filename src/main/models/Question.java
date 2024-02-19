
package main.models;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Question {
    private String statement;
    private ArrayList<Answer> respuesta;
    private String justification;
    private String domain;
    
    public Question(String statement, ArrayList<Answer> respuesta, String justification, String domain){
        this.statement = statement;
        this.respuesta = respuesta;
        this.justification = justification;
        this.domain = domain;
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

    @SuppressWarnings("unchecked")
    public JSONObject toJSON()
    {
        JSONObject questionJSON = new JSONObject();
        JSONArray answerArray = new JSONArray();
        questionJSON.put("domain", this.domain);
        answerArray.addAll(this.respuesta.stream().map(Answer::toJSON).collect(Collectors.toList()));
        questionJSON.put("text", this.statement);
        questionJSON.put("answers", answerArray);
        questionJSON.put("justification", this.justification);
        return questionJSON;
    }
}
