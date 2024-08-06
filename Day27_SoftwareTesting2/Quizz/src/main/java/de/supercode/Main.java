package de.supercode;

public class Main {
    public static void main(String[] args) {
        // Creating a quiz
        Quiz quiz = new Quiz();

        // Creating questions
        String description1 = "What is the capital of Luxembourg?";
        String[] choices1 = {"Luxembourg", "Angola", "Berlin", "NRW"};
        String[] correctChoices1 = {"Luxembourg"};
        Question question1 = new Question(description1, choices1, correctChoices1);

        String description2 = "Which country has the largest population?";
        String[] choices2 = {"China", "India", "USA", "Brazil"};
        String[] correctChoices2 = {"China"};
        Question question2 = new Question(description2, choices2, correctChoices2);

        String description3 = "Which of these countries are in Asia?";
        String[] choices3 = {"China", "India", "USA", "Brazil"};
        String[] correctChoices3 = {"China", "India"};
        Question question3 = new Question(description3, choices3, correctChoices3);

        // Adding questions to the quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Creating a user
        User user = new User("Alice");

        // Conducting the quiz
        int correctAnswers = quiz.askQuestions(user);

        // Displaying the results
        System.out.println("Quiz completed!");
        System.out.println("User: " + user.getUsername());
        System.out.println("Points scored: " + user.getScore());
        System.out.println("Number of correct answers: " + correctAnswers + " out of " + quiz.getQuestions().size());
    }
}