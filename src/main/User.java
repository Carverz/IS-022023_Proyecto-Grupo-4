package main;
public class User{
    private String name;
    private String mail;
    private String password;
    private int[] courseId;

    public User(){};

    public User(String name, String mail, String password, int[] courseId){
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.courseId = courseId;
    }

    
    public int[] getCourseData(){
        return this.courseId;
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
