package test;

import main.models.User;
import org.junit.Test;
import static org.junit.Assert.*;
import main.controllers.ProfileController;

public class ProfileControllerTest {

    @Test
    public void testGetName() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password", new int[]{0, 1, 2});
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertEquals("Lenguaje de Programación Java: Nivel Basico", controller.getName(0));
        assertEquals("Lenguaje de Programación C++: Nivel Basico", controller.getName(1));
        assertEquals("Lenguaje de Programación PHP: Nivel Basico", controller.getName(2));
    }

    @Test
    public void testGetName_InvalidIndex() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password", new int[]{-1, -1, -1});
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertNull(controller.getUserName());
        assertNull(controller.getUserName());
        assertNull(controller.getUserName());
    }

    @Test
    public void testGetUserName() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password", new int[]{0, 1, 2});
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertEquals("Carlos Zavarce", controller.getUserName());
    }

    @Test
    public void testGetUserMail() {
        // Arrange
        User user = new User("Carlos Zavarce", "cezavarcev16@gmail.com", "password", new int[]{0, 1, 2});
        ProfileController controller = new ProfileController(user);

        // Act & Assert
        assertEquals("cezavarcev16@gmail.com", controller.getUserMail());
    }
}