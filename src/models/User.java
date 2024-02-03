public class User{
    private String name;
    private String lastName;
    private String mail;
    private String courseId;

    
    public String getCourseData(User usuario){
        return usuario.courseId;
    }
}