public class geradeZahlen {
    public static void main(String[] args) {
        int summe = 0;
        for (int i = 1; i <= 100; i++) {
            if (i%2 == 0) {
                summe += i;  
                System.out.println(summe);
            }
        }
    }
}
