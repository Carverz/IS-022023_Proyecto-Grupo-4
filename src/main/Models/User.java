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

    
    public String getCourseData(User usuario){
        return this.courseId;
    }
    public String getPassword(User usuario){
        return this.password;
    }
    public String getMail(User usuario){
        return this.mail;
    }
    public String getName(User usuario){
        return this.name;
    }
}