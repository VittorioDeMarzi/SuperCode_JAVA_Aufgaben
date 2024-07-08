public class ExerciseSheet {
    private int numberExercise;
    private int maximumNumberOfPoints;
    private int achievedPoints;

    public ExerciseSheet(int numberExercise, int maximumNumberOfPoints, int achievedPoints) {
        this.achievedPoints = achievedPoints;
        this.maximumNumberOfPoints = maximumNumberOfPoints;
        this.numberExercise = numberExercise;
    }

    public int getNumberExercise() {
        return numberExercise;
    }

    public void setNumberExercise(int numberExercise) {
        this.numberExercise = numberExercise;
    }

    public int getMaximumNumberOfPoints() {
        return maximumNumberOfPoints;
    }

    public void setMaximumNumberOfPoints(int maximumNumberOfPoints) {
        this.maximumNumberOfPoints = maximumNumberOfPoints;
    }

    public int getAchievedPoints() {
        return achievedPoints;
    }

    public void setAchievedPoints(int achievedPoints) {
        this.achievedPoints = achievedPoints;
    }

    @Override
    public String toString() {
        return "Num Exercise: " + this.numberExercise + " Maximal Points: " + this.maximumNumberOfPoints + " Achieved Points: " + this.achievedPoints;
    }
}
