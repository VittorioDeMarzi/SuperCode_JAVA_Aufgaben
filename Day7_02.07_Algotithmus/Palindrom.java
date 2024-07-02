public class Palindrom {
    
    public static boolean checkPalindrom(String input) {
        String inputLower = input.toLowerCase();
        String stringToCheck = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                stringToCheck += inputLower.charAt(i);
            }
        }
        
        String reverse = "";
        for (int i = stringToCheck.length() - 1; i >= 0; i--) {
            reverse += stringToCheck.charAt(i);
        }
        return stringToCheck.equals(reverse);
        
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


