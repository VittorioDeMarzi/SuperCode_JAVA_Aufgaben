package de.supercode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizTest {

    private String description;
    private String[] choices;
    private String[] correctAnswers;
    private User user;

    @BeforeAll
    void initTestData() {
        this.description = "Was ist die Hauptstadt von Deutschlan?";
        this.choices = new String[] {"Luxemburg", "Angola", "Berlin", "NRW"};
        this.correctAnswers = new String[] {"Berlin"};
        this.user = new User("Vittorio");
    }

    @Test
    public void canAssertWrongAnswer() {
        String[] chosen = {"NRW", "Angola"};
        Question q = new Question(this.description, this.choices, this.correctAnswers);
        assertFalse(q.answerQuestion(chosen));
    }

    @Test
    public void canAssertWrongAnswer2() {
        String[] chosen = {"NRW", "Berlin"};
        Question q = new Question(this.description, this.choices, this.correctAnswers);
        assertFalse(q.answerQuestion(chosen));
    }

    @Test
    public void canAssertCorrectAnswer() {
        String[] chosen = {"Berlin"};
        Question q = new Question(this.description, this.choices, this.correctAnswers);
        assertTrue(q.answerQuestion(chosen));
    }

    //    Testing for setDescription. Description hat to end with ?
    @Test
    public void questionDescriptionInvalid() {
        String description = "Was ist die Hauptstadt von Deutschlan";
        assertThrows(IllegalArgumentException.class, () -> new Question(description, this.choices, this.correctAnswers));
    }

    //    At least two choices must be provided
    @Test
    public void twoChoisesAreNeeded() {
        String[] choices = {"Berlin"};
        assertThrows(IllegalArgumentException.class, () -> new Question(this.description, choices, this.correctAnswers));
    }

    //    Correct choices must be a subset of choices
    @Test
    public void answerHasToBeInChoises() {
        String[] correctAnswers = {"Rome"};
        assertThrows(IllegalArgumentException.class, () -> new Question(this.description, this.choices, correctAnswers));
    }

    //    Die Methoden getUsername(), getScore() und incrementScore() korrekt funktionieren.
    @Test
    public void canGetUsername() {
        Question q = new Question(this.description, this.choices, this.correctAnswers);
        assertEquals("Vittorio", user.getUsername());
    }
}

