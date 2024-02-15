package test;

import java.util.ArrayList;
import main.models.Question;
import org.junit.Test;
import static org.junit.Assert.*;
import main.models.Exam;

public class ExamTest {

    @Test
    public void testConstructor() {
        // Arrange
        ArrayList<Question> preguntas = new ArrayList<>();
        preguntas.add(new Question("Pregunta 1", new ArrayList<>(), "Justificación 1"));
        preguntas.add(new Question("Pregunta 2", new ArrayList<>(), "Justificación 2"));
        int minuteTime = 60;

        // Act
        Exam exam = new Exam(preguntas, minuteTime);

        // Assert
       
        assertNotNull(exam);
        assertEquals(preguntas.size(), exam.getQuestionNumber());
        for (int i = 0; i < preguntas.size(); i++) {
            assertEquals(preguntas.get(i).getStatement(), exam.getPreguntas(i).getStatement());
        }
        assertEquals(minuteTime, exam.getMinuteTime());
        assertEquals(0, exam.getResult());
    }

    @Test
    public void testIncreaseResult() {
        // Arrange
        ArrayList<Question> preguntas = new ArrayList<>();
        preguntas.add(new Question("Pregunta 1", new ArrayList<>(), "Justificación 1"));
        preguntas.add(new Question("Pregunta 2", new ArrayList<>(), "Justificación 2"));
        int minuteTime = 60;
        Exam exam = new Exam(preguntas, minuteTime);

        // Act
        exam.increaseResult();

        // Assert
        assertEquals(1, exam.getResult());
    }
}