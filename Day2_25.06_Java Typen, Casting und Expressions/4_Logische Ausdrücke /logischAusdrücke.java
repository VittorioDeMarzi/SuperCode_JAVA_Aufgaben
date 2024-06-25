// # Gebe für jeden der angegeben Ausdrücke einen entsprechenden Java Ausdruck an:


public class logischAusdrücke {
    public static void main(String[] args) {
        
        // 1_ Überprüfe, ob eine Zahl zwischen 10 und 20 liegt
        int zahl = 15;
        boolean check = zahl >= 10 && zahl <= 20;
        System.out.printf("Liegt die Zahl %s zwischen 10 und 20? %s%n", zahl, check);

        // 2_ Bestimme, ob eine Person entweder zwischen 18 und 25 Jahren alt ist oder älter als 65 Jahre
        int age = 45;
        check = (age >= 18 && age <= 25) || age >= 65;
        System.out.printf("%s%n", check);

        // 3_ Schreibe einen Ausdruck, der wahr ist, wenn mindestens zwei von drei Zahlen positiv sind
        int num1 = 4;
        int num2 = 4;
        int num3 = 4;
        check = (num1 > 0 && num2 > 0) || (num2 > 0 && num3 > 0) || (num1 > 0 && num3 > 0);
        System.out.printf("num1= %s num1= %s num1= %s%n Sind mindestens zwei davon positiv? %s%n", num1, num2, num3,
                check);
        
        // 4_ Schreibe einen Ausdruck, der wahr ist, wenn eine Zahl weder durch 2 noch durch 3 teilbar ist
        int num = 18;
        check = num % 2 == 0 && num % 3 == 0;
        System.out.printf("Ist Zahl %s weder durch 2 noch durch 3 teilbar? %s%n", num, check);

        // 5_ a, b und c sind alle 0
        check = num1 == 0 && num2 == 0 && num3 == 0;
        System.out.printf("Sind %s %s %s alle drei null? %s%n", num1, num2, num3, check);

        // 6_  a, b und c haben den gleichen Wert
        check = num1 == num2 && num2 == num3;
        System.out.printf("Haben %s %s %s den gleichen Wert? %s%n", num1, num2, num3, check);

        // 7_ genau eines von a, b und c ist falsch
        boolean a = true;
        boolean b = true;
        boolean c = true;
        check = a == false || b == false || c == false;
        System.out.printf("Ist eine davon false? %s%n", check);

        // 8_ a ist ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11

        int zahl1 = 77;
        check = (zahl1 % 2 == 0 && zahl1 % 7 == 0) || (zahl1 % 7 == 0 && zahl1 % 11 == 0);
        System.out.printf("ist %s ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11? %s%n", zahl1, check);

        //9_ a, b und c sind alle drei true oder alle drei false
        check = (a == true && b == true && c == true) || (a == false && b == false && c == false);
        System.out.printf("Sind alle 3 positive oder negative? %s%n", check);
    }
}