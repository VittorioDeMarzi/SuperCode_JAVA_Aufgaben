import java.util.Random;

public class MainCalculator {
    public static void main(String[] args) {
        Random random = new Random();
        ExerciseSheet[] exercises = new ExerciseSheet[13];
        int totalAchievablePoints = 0;
        int achievedPoints = 0;

        for (int i = 1; i < 14; i++) {
            exercises[i - 1] = new ExerciseSheet(i, 60, random.nextInt(61));
            System.out.println(exercises[i - 1].toString());
        }

        for (ExerciseSheet ex : exercises) {
            totalAchievablePoints += ex.getMaximumNumberOfPoints();
            achievedPoints += ex.getAchievedPoints();
        }

        System.out.println("Total number of maximum achievable points: " + totalAchievablePoints);
        System.out.println("total number of points achieved: " + achievedPoints);

        double percentage = calcultePercentage(totalAchievablePoints, achievedPoints);

        if (percentage >= 50) {
            System.out.printf("Exam Passing Threshold of 50%% has been met with a result of: %.1f%n", percentage);
        } else
            System.out.printf("Exam Passing Threshold of 50%% hasn't been met with a result of: %.1f%n", percentage);
        
        ExerciseSheet highest = getHeighestPoint(exercises);
        System.out.println("""
                           Exercise sheet with the highest points: 
                           """ + highest);
        ExerciseSheet lowest = getLowestPoint(exercises);
        System.out.println("""
                           Exercise sheet with the lowest points: 
                           """ + lowest);

    }

    private static ExerciseSheet getHeighestPoint(ExerciseSheet[] exercises) {
        ExerciseSheet heighestEx = exercises[0];
        int heighestPoint = exercises[0].getAchievedPoints();
        for (ExerciseSheet ex : exercises) {
            if (ex.getAchievedPoints() > heighestPoint) {
                heighestEx = ex;
            }
        }
        return heighestEx;

    }
    private static ExerciseSheet getLowestPoint(ExerciseSheet[] exercises) {
        ExerciseSheet lowestEx = exercises[0];
        int lowestPoint = exercises[0].getAchievedPoints();
        for (ExerciseSheet ex : exercises) {
            if (ex.getAchievedPoints() < lowestPoint) {
                lowestEx = ex;
            }
        }
        return lowestEx;
    }

    private static double calcultePercentage(int totalAchievablePoints, int achievedPoints) {
        return ((double) achievedPoints / (double) totalAchievablePoints) * 100;
    }
}
