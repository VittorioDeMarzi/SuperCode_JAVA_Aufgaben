package de.supercode;

public class StringCompressor {
    public static String compress(String input) {
        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int counter = 1;

        for (int i=1; i<input.length(); i++) {
            if (input.charAt(i) != currentChar) {
                result.append(currentChar);
                if (counter >1) result.append(counter);
                currentChar = input.charAt(i);
                counter = 1;
            } else counter ++;
        }
        result.append(currentChar);
        if (counter >1) result.append(counter);

        return result.toString();
    }
}
