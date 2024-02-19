
package main.models;

import org.json.simple.JSONObject;

public class Answer {
    private String text;
    private boolean right;

    public Answer(String text, boolean right) {
        this.text = text;
        this.right = right;
    }

    public Answer(String text) {
        this.text = text;
    }

    public boolean isRight() {
        return this.right;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON()
    {
        JSONObject answerJSON = new JSONObject();
        answerJSON.put("text", this.text);
        answerJSON.put("trueOrFalse", this.right);
        return answerJSON;
    }

}
