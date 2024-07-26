package de.supercode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str = "abcda";
        longestSubstring(str);
    }

    private static void longestSubstring(String str) {
        System.out.println("Longest Substring Without Repeating Characters");
        System.out.println("Input: " + str);
        HashMap<Character, Integer> map = new HashMap<>();
        int longestSubstringLength;
        String longestSubstring;
        for (int i=0; i<str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i),1);
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