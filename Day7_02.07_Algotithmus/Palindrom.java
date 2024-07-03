public class Palindrom {
    
    public static boolean checkPalindrom(String input) {
        String inputLower = input.toLowerCase();
        String stringToCheck = removeSpaces(inputLower);
        String reverse = reverstString(stringToCheck);
        return stringToCheck.equals(reverse);   
    }

    private static String removeSpaces(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                output += str.charAt(i);
            }
        }
        return output;
    }

    private static String reverstString(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    public static void main(String[]args) {
        String test1 = "Amok Oma";
        String test2 = "Ein Esel lese nie";
        String test3 = "Lagerregal";
        String test4 = "Hi I am Vittorio";
        String test5 = "abbabba";

        System.out.println(checkPalindrom(test1));
        System.out.println(checkPalindrom(test2));
        System.out.println(checkPalindrom(test3));
        System.out.println(checkPalindrom(test4));
        System.out.println(checkPalindrom(test5));
    }

}


