public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs)); // Output: "fl"
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return null;
        int shortestWordMaxIndex = getLengthShortestWord(strs)-1;
        String prefix = strs[0].substring(0, shortestWordMaxIndex);
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;

    }

    private static int getLengthShortestWord(String[] strs) {
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length()<minLength) minLength = str.length();
        }
        return minLength;
    }
}
