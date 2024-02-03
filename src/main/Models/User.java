public class User{
    private String name;
    private String mail;
    private String password;
    private String courseId;

    User(){};

    User(String name, String mail, String password, String courseId){
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.courseId = courseId;
    }

    
    public String getCourseData(){
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