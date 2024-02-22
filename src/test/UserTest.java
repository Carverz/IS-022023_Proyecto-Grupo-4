package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.models.User;

public class UserTest {

    @Test
    public void testConstructor() {
        String expectedName = "Carlos";
        String expectedMail = "cezavarcev16@gmail.com";
        String expectedPassword = "password";

        User user = new User(expectedName, expectedMail, expectedPassword);
        
        assertEquals(expectedName, user.getName());
        assertEquals(expectedMail, user.getMail());
        assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    public void testGetPassword() {
        String expectedPassword = "password";
        User user = new User("Carlos", "cezavarcev16@gmail.com", expectedPassword);
        
        assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    public void testGetMail() {
        String expectedMail = "cezavarcev16@gmail.com";
        User user = new User("Carlos", expectedMail, "password");
        
        assertEquals(expectedMail, user.getMail());
    }

    @Test
    public void testGetName() {
        String expectedName = "Carlos";
        User user = new User(expectedName, "cezavarcev16@gmail.com", "password");
        
        assertEquals(expectedName, user.getName());
    }
}