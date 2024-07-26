package de.supercode;

public class Main {
    public static void main(String[] args) {
        String input = "      -10000003dghijd456";

        System.out.println(myAtoi(input));
    }

    private static int myAtoi(String s) {
        String str = s.strip();
        String number = "";
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int index = 0;

        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            number += str.charAt(index);
            index = 1;
        }
        if(!Character.isDigit(str.charAt(index))) {
            return 0;
        }
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            number += str.charAt(index);
            index++;
        }
        return Integer.parseInt(number);
    }
}