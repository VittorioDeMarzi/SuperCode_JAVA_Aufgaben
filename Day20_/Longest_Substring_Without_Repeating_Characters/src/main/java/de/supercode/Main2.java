package de.supercode;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) {
        String str = "qwertzqasdfcm";
        longestSubstring(str);
    }

    private static void longestSubstring(String str) {
        System.out.println("Longest Substring Without Repeating Characters");
        System.out.println("Input: " + str);
        ArrayList<Character>  letters = new ArrayList<>();
        int longestSubstringLength;
        String longestSubstring ="";
        String temp = "";
        int index = 0;
        while (longestSubstring.length()<str.length()) {
            for (int i=0; i<str.length(); i++) {
                if (!letters.contains(str.charAt(i))) {
                    letters.add(str.charAt(i));
                } else {
                    temp = str.substring(0, i);
                    str = str.substring(i);
                    break;
                }
                temp = str.substring(0);
            }
            if (temp.length()>longestSubstring.length()) longestSubstring = temp;
            letters.clear();
        }
        System.out.println("Output: " + longestSubstring.length());
        System.out.println("Substring: " + longestSubstring);

    }
}