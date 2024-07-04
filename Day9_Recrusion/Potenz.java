public class Potenz {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int exponent = Integer.parseInt(args[1]);
        double potenz = pow(n, exponent);
        System.out.println(potenz);
    }

    private static double pow(int n, int exponent) {
        double output = 1;

        if (exponent == 0)
            return output;
        if (exponent < 0)
            return (1 / ((output*(double)n))) * pow(n, exponent + 1);
        else    
            return (output*n) * pow(n, exponent - 1);
    }
}
