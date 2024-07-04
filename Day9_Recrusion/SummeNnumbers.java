public class SummeNnumbers {
    public static void main(String[] args) {
        int n = 2;
        int summe = summe(n);
        System.out.println(summe);
    }

    private static int summe(int n) {
        int output = 0;
        if (n > 0)
            return n + summe(n-1);
        return output;
    }
}
