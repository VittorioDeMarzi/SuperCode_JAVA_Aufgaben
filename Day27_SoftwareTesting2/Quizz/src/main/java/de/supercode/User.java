package de.supercode;

public class User {
    private String username;
    private int score;

    public User(String username) {
        this.username = username;
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int increment) {
        if (increment <= 0) throw new IllegalArgumentException("Increment hat to be positiv");
        this.score += increment;
    }
}
