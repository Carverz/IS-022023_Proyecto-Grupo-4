package views;
import models.user;

public class Main {
    public static void Main(String[] args) {
        userView ui = new userView();
        user User = new user();
        user.setName("Carlos Zavarce");
        user.setEmail("Carverz65@gmail.com");
        ui.setUsername(user.getName());
        ui.setEmail(user.getEmail());
        ui.setVisible(true);
    }
}