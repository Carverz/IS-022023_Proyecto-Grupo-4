package main.models;
public class User{
    public String name;
    private String mail;
    private String password;
   

    public User(){};

    public User(String name, String mail, String password){
        this.name = name;
        this.password = password;
        this.mail = mail;
        
    }

    
   
    public String getPassword(){
        return this.password;
    }
    public String getMail(){
        return this.mail;
    }
    public String getName(){
        return this.name;
    }
}
