
package main.models;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Question {
    private String statement;
    private ArrayList<Answer> answer;
    private String justification;
    private String domain;
    private String img;
    
    public Question(String statement, ArrayList<Answer> answer, String justification, String domain){
        this.statement = statement;
        this.answer = answer;
        this.justification = justification;
        this.domain = domain;
        this.img = "";
    }
    
    public Question(String statement, ArrayList<Answer> answer){
        this.statement = statement;
        this.answer = answer;
    }

    public Question(){}
    
    public String getStatement(){
        return statement;
    }
    
    public int getAnswerNumber(){
        return this.answer.size();
    }
    
    public Answer getAnswer(int i){
        return this.answer.get(i);
    }

    public String getImg(){
        return img;
    }

    public String getJustification(){
        return justification;
    }

    public void setImg(String i){
        img = i;
    }
    public void setDomain(String d){
        domain = d;
    }
    public void setJust(String j){
        justification = j;
    }
    public void setAnswer(ArrayList<Answer> a){
        answer = a;
    }
    public void setStatement(String s){
        statement = s;
    }


    @SuppressWarnings("unchecked")
    public JSONObject toJSON()
    {
        JSONObject questionJSON = new JSONObject();
        JSONArray answerArray = new JSONArray();
        questionJSON.put("domain", this.domain);
        questionJSON.put("imgPath", this.img);
        answerArray.addAll(this.answer.stream().map(Answer::toJSON).collect(Collectors.toList()));
        questionJSON.put("text", this.statement);
        questionJSON.put("answers", answerArray);
        questionJSON.put("justification", this.justification);
        return questionJSON;
    }
}
