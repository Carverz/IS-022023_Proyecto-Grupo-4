package test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import main.models.Answer;
import main.models.Question;

public class QuestionTest {

    @Test
    public void testConstructorWithJustification() {
        // Arrange
        String statement = "¿Cuál de las siguientes afirmaciones describe mejor el concepto de polimorfismo en Java? ";
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(new Answer("El polimorfismo en Java se refiere a la capacidad de un objeto para tomar diferentes formas y comportarse de diferentes maneras en función del contexto en el que se utiliza.", true ));
        answers.add(new Answer("El polimorfismo en Java se refiere únicamente a la capacidad de una clase para heredar propiedades y comportamientos de otra clase.", false));
        String justification = "El polimorfismo en Java realmente se refiere a la capacidad de un objeto para presentar múltiples formas o comportamientos, lo que permite que una variable de tipo de una clase padre pueda referirse a una instancia de cualquiera de sus subclases. Esto se logra mediante el uso de la herencia y la sobrescritura de métodos.";

        // Act
        String domain = "";
        Question question = new Question(statement, answers, justification, domain );

        // Assert
        assertNotNull(question);
        assertEquals(statement, question.getStatement());
        assertEquals(2, question.getAnswerNumber());
    }

}