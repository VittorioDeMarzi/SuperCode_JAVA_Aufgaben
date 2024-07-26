package de.supercode;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) {
        String str = "abcda";
        longestSubstring(str);
    }

    private static void longestSubstring(String str) {
        System.out.println("Longest Substring Without Repeating Characters");
        System.out.println("Input: " + str);
        ArrayList<Character>  letters = new ArrayList<>();
        int longestSubstringLength;
        String longestSubstring;
        for (int i=0; i<str.length(); i++) {
            if (!letters.contains(str.charAt(i))) {
                letters.add(str.charAt(i));
            } else {
                longestSubstring = str.substring(0, i);
                System.out.println("Output: " + longestSubstring.length());
                System.out.println("Substring: " + longestSubstring);
                return;
            }
        }
        System.out.println("Output: " + str.length());
        System.out.println("Substring: " + str);

    }
}
