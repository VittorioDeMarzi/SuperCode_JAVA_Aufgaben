// "Hallo mein Name ist Vittorio"

// split(str, "e")
// -> "Hallo m"
// -> "in"
// -> " Nam"
// -> " ist Vittorio"


public class Split {
    
    public static void main(String[] args) {
        String str = "Hallo meine Name ist Vittorio!";
        String[] strSplitted = split(str, "e");
        for (int i = 0; i < strSplitted.length; i++) {
            System.out.println(strSplitted[i]);
        }
    }
    
    public static String[] split(String input, String delimiter) {

        int numDelimiters = countNumberDelimiters(input, delimiter);
        String[] subStrings = new String[numDelimiters + 1];

        for (int i = 0; i < subStrings.length; i++) {
            int delimiterIndex = input.indexOf(delimiter);
            if (delimiterIndex != -1) {
                subStrings[i] = input.substring(0, delimiterIndex);
                input = input.substring(delimiterIndex + 1);
            } else {
                subStrings[i] = input;
            }
        }
        return subStrings;
    }

    private static int countNumberDelimiters(String input, String delimiter) {
        System.out.println("check1");
        int counter = 0;
        int from = 0;

        while (input.indexOf(delimiter, from) != -1) { 
            counter += 1;
            from += input.indexOf(delimiter, from);
        }
        return counter;
    }
}
