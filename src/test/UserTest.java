package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.models.User;

public class UserTest {

    @Test
    public void testConstructor() {
        String expectedName = "John";
        String expectedMail = "john@example.com";
        String expectedPassword = "password";
        int[] expectedCourseIds = {1, 2, 3};

        User user = new User(expectedName, expectedMail, expectedPassword, expectedCourseIds);
        
        assertEquals(expectedName, user.getName());
        assertEquals(expectedMail, user.getMail());
        assertEquals(expectedPassword, user.getPassword());
        assertArrayEquals(expectedCourseIds, user.getCourseData());
    }

    @Test
    public void testGetCourseData() {
        int[] expectedCourseIds = {1, 2, 3};
        User user = new User("John", "john@example.com", "password", expectedCourseIds);
        
        assertArrayEquals(expectedCourseIds, user.getCourseData());
    }

    @Test
    public void testGetPassword() {
        String expectedPassword = "password";
        User user = new User("John", "john@example.com", expectedPassword, new int[]{});
        
        assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    public void testGetMail() {
        String expectedMail = "john@example.com";
        User user = new User("John", expectedMail, "password", new int[]{});
        
        assertEquals(expectedMail, user.getMail());
    }

    @Test
    public void testGetName() {
        String expectedName = "John";
        User user = new User(expectedName, "john@example.com", "password", new int[]{});
        
        assertEquals(expectedName, user.getName());
    }
}