// Schreibe ein Programm, welches eine Temperatur als Befehlszeilenargument einliest, sie in Fahrenheit umwandelt und anschließend ausgibt. 

// ### Formel:  **(°C x 9/5) + 32 = °F**

public class temperatur {
public static void main(String[] args) {
    double temperaturC = Double.parseDouble(args[0]);
    double temperaturF = (temperaturC * (9.0 / 5.0)) + 32;
    double ratio = (9 / 5);
    System.out.printf("%s Grad sind %s Fahrenheit", temperaturC, temperaturF);
}
}