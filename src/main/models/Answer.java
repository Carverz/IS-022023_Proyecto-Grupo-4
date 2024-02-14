
package models;


public class Answer {
   private String text;
   private boolean right;
   private String dominio;
   
   public Answer(String text, boolean right,String dominio){
        this.text = text;
        this.right = right;
        this.dominio = dominio;
    }   
   
   public Answer(String text){
        this.text = text;
    }   
   
   public boolean isRight(){
       return this.right;
   }
   
   public String getText(){
       return this.text;
   }
   
   public void setText(String text) {
    this.text = text;
}
   
}



