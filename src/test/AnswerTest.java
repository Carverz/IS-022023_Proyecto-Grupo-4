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

        // Act
        Answer answer = new Answer(text, right);

        // Assert
        assertEquals(text, answer.getText());
        assertEquals(right, answer.isRight());
    }

    @Test
    public void testIsRight() {
        // Arrange
        String text = "True";
        boolean right = false;
        Answer answer = new Answer(text, right);

        // Act & Assert
        assertEquals(false, answer.isRight());
    }
}