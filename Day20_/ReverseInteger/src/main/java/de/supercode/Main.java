package de.supercode;

public class Main {
    public static void main(String[] args) {
        int input =  -123564;
        int result = invertInt(input);
        System.out.println(result);
    }

    private static int invertInt(int input) {
        int result = 0;
        if (input/10 == 0) return input;
        while(input != 0)  {
            int newDigit = input%10;
            if (((result*10) + newDigit) < Math.pow(2,31)-1 && ((result*10) + newDigit) > -Math.pow(2,31)) {
                result = (result * 10) + newDigit;
                input = input / 10;
            } else return 0;
        }
        return result;
    }
}