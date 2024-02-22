package test;

import main.models.User;
import org.junit.Test;
import static org.junit.Assert.*;
import main.controllers.ProfileController;

public class ProfileControllerTest {

    @Test
    public void testGetUserName() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password");
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertEquals("Carlos Zavarce", controller.getUserName());
    }

    @Test
    public void testGetUserMail() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password");
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertEquals("cezavarcev16@gmail.com", controller.getUserMail());
    }
}