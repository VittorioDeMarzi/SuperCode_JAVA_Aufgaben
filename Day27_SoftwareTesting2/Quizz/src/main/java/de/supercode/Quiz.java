package de.supercode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;

    public static final String EXIT = "5";

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        if (question == null) throw new IllegalArgumentException("Question hat to be complete");
        questions.add(question);
    }

    public int askQuestions(User user) {
        Scanner sc = new Scanner(System.in);
        int currentPoints = 0;
        String[] answers;
        for (Question q : questions) {
            q.printQuestion();
            String answer = sc.nextLine();
            if (EXIT.equals(answer)) {
                System.out.println("Quiz will be ended");
                break;
            }

            answers = getNumericalAnswers(answer, q.getChoices());
            boolean inputOutOfBound = checkInputOutOfBound(answers, q.getChoices());
            if (inputOutOfBound) {
                System.out.println("Invalid Input");
                continue;
            }
            answers = getAnswers(answers, q.getChoices());
            if (q.answerQuestion(answers)) {
                System.out.println("🥳 CORRECT");
                user.incrementScore(1);
                currentPoints++;
            } else System.out.println("☹️ WRONG");
        }
        sc.close();
        return currentPoints;
    }

    private boolean checkInputOutOfBound(String[] answers, String[] choices) {
        for (String str : answers) {
            if (Integer.parseInt(str) < 0  || Integer.parseInt(str) > choices.length) return true;
        }
        return false;
    }

    private String[] getNumericalAnswers(String answer, String[] choices) {
        String[] choosenAnswersInInteger;
        if (answer.length() == 1) choosenAnswersInInteger = new String[]{answer};
        else if (answer.contains(", ")) choosenAnswersInInteger = answer.split(", ");
        else choosenAnswersInInteger = answer.split(",");
        return choosenAnswersInInteger;
    }

    private String[] getAnswers(String[] answer, String[] choices) {
        List<String> answersList = new ArrayList<>();

        for (String str : answer) {
            int index = Integer.parseInt(str);
            answersList.add(choices[index-1]);
        }
        String[] result = new String[answersList.size()];
        result = answersList.toArray(result);
        return result;
    }


}
