public class Substring {

    public static String subtring(String input, int start, int end) {
        String output = "";
        for (int i = start; i < end; i++) {
            output += input.charAt(i);
        }
        return output;
    }
    
    public static void main(String[] args) {
        System.out.println(subtring("Programmieren", 3, 7));
        System.out.println(subtring("Hi, my name is Vittorio", 5, 9));
    }
}