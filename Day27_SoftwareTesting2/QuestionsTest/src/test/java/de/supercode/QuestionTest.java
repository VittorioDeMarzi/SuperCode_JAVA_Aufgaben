package de.supercode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    public void canAssertWrongAnswer() {
        String description = "Was ist die Hauptstadt von Deutschlan?";
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctAnswers = {"Berlin"};
        String[] chosen = {"NRW", "Angola"};
        Question q = new Question(description, choices, correctAnswers);
        assertEquals(false, q.answerQuestion(chosen));
    }

    @Test
    public void canAssertWrongAnswer2() {
        String description = "Was ist die Hauptstadt von Deutschlan?";
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctAnswers = {"Berlin"};
        String[] chosen = {"NRW", "Berlin"};
        Question q = new Question(description, choices, correctAnswers);
        assertEquals(false, q.answerQuestion(chosen));
    }

    @Test
    public void canAssertCorrectAnswer() {
        String description = "Was ist die Hauptstadt von Deutschlan?";
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctAnswers = {"Berlin"};
        String[] chosen = {"Berlin"};
        Question q = new Question(description, choices, correctAnswers);
        assertEquals(true, q.answerQuestion(chosen));
    }

//    Testing for setDescription. Description hat to end with ?
    @Test
    public void questionDescriptionInvalid() {
        String description = "Was ist die Hauptstadt von Deutschlan";
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctAnswers = {"Berlin"};
        assertThrows(IllegalArgumentException.class, () -> new Question(description, choices, correctAnswers));
    }

//    At least two choices must be provided
    @Test
    public void twoChoisesAreNeeded() {
        String description = "Was ist die Hauptstadt von Deutschlan?";
        String[] choices = {"Berlin"};
        String[] correctAnswers = {"Berlin"};
        assertThrows(IllegalArgumentException.class, () -> new Question(description, choices, correctAnswers));
    }

//    Correct choices must be a subset of choices
    @Test
        public void answerHasToBeInChoises() {
        String description = "Was ist die Hauptstadt von Deutschlan?";
        String[] choices = {"Luxemburg", "Angola", "Berlin", "NRW"};
        String[] correctAnswers = {"Rome"};
        assertThrows(IllegalArgumentException.class, () -> new Question(description, choices, correctAnswers));
    }
}