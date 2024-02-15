package test;
import org.junit.Test;
import static org.junit.Assert.*;
import main.models.Answer;

public class AnswerTest {

    @Test
    public void testConstructor() {
        // Arrange
        String text = "Paris";
        boolean right = true;
        String domain = "geography";

        // Act
        Answer answer = new Answer(text, right, domain);

        // Assert
        assertEquals(text, answer.getText());
        assertEquals(right, answer.isRight());
    }

    @Test
    public void testIsRight() {
        // Arrange
        String text = "True";
        Answer answer = new Answer(text);

        // Act & Assert
        assertEquals(false, answer.isRight());
    }
}