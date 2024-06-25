

/* Wir wollen eine kleine Formelsammlung rund um das Rechteck erstellen:  
    java Rechteck 2 3
    Umfang = 10
    Flächeninhalt = 6
    Diagonalenlänge = 3.60555127546
    Umkreisradius = 1.80277563773
*/

public class rechteck {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int umfang = (2 * a) + (2 * b);
        int flächeninhalt = a * b;
        double diagonalenlänge = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double umkreisradius = diagonalenlänge / 2;

        System.out.printf("Umfang = %s%n", umfang);
        System.out.printf("Flächeninhalt = %s%n", flächeninhalt);
        System.out.printf("Diagonalenlänge = %s%n", diagonalenlänge);
        System.out.printf("Umkreisradius = %s%n", umkreisradius);

    }
}