public class CompareTo {

    public static int compareTo(String s1, String s2) {
        int s1Lenght = s1.length();
        int s2Lenght = s2.length();

        int minLenght = Math.min(s1Lenght, s2Lenght);
        
        for (int i = 0; i < minLenght; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        if (s1Lenght>minLenght) {
            return 1;
        } else if (s1Lenght==s2Lenght) { 
            return 0;           
        } else return -1;
    }
    
    public static void main(String[] args) {
        System.out.println("1: " + compareTo("", ""));
        System.out.println("2: " + compareTo("", "abc"));
        System.out.println("3: " + compareTo("String", "stringajzfgfkd"));
        System.out.println("4: " + compareTo("hall", "hallo"));
        System.out.println("5: " + compareTo("hallo", "hall"));
        System.out.println("6: " + compareTo("0", " "));
        System.out.println("7: " + compareTo("hallo", "hallo"));
    }
}
