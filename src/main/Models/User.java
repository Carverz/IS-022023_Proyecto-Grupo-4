public class User{
    private String name;
    private String mail;
    private String password;
    private String courseId;

    
    public String getCourseData(User usuario){
        return usuario.courseId;
    }
    public String getPassword(User usuario){
        return usuario.password;
    }
    public String getMail(User usuario){
        return usuario.mail;
    }
    public String getName(User usuario){
        return usuario.name;
    }
}