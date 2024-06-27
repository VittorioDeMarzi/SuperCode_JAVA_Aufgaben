/* Welchen Wert haben a, b und c jeweils am Ende der Anweisung:
a) int a = 0;
   for(int i = 0; i < 10; i++){ 
			a+=i;
	 }                          // a = 45

c) int b = 0;
   for(b = 0; b < 10; b++){ 
			b+=b;
	 }                          // b = 45 (?)

d) int c = 0;
   for(int i = 0; i < 10; i++){ 
			c+=c++;
    }                           // c = 0
 */

 public class endwerte {
     public static void main(String[] args) {
         int a = 0;
         for (int i = 0; i < 10; i++) {
             a += i;
         }
         System.out.println(a);
         int b = 0;
         for (b = 0; b < 10; b++) {
             b += b;
         }
         System.out.println(b);
         int c = 0;
         for (int i = 0; i < 10; i++) {
             c += c++;
         }
         System.out.println(c);

         int n = 123456789;
         int m = 0;
         while (n != 0) {
             m = (10 * m) + (n % 10);
             n = n / 10;
             System.out.println(n + " " + m);
         }
     }
}
