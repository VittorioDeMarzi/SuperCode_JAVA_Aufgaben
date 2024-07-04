public class Factorial {
    public static void main(String[] args) {
        int n=3;
        int factorial = factorial(n);
        System.out.println(factorial);
    }

    private static int factorial(int n) {
        int output = 1;
        if (n > 0)
            return n * factorial(n - 1);
        return output;
    }
}