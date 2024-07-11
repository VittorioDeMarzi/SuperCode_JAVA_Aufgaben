
import java.time.Duration;
import java.time.LocalDateTime;

// # 4. **Zeitdifferenz zwischen zwei Zeitpunkten berechnen**

// Schreibe ein Programm, das die Zeitdifferenz zwischen zwei Zeitpunkten in Stunden und Minuten berechnet.

public class Datum4 {
    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.of(2020, 6, 23, 20, 34, 55);
        LocalDateTime date2 = LocalDateTime.now();
        Duration difference = Duration.between(date1, date2);


        System.out.println(difference.toDays());
        System.out.println(difference.toHours());
        System.out.println(difference.toMinutes());
    }
}
