import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// # 2. **Datum in die Zukunft oder Vergangenheit verschieben:**

// Schreibe ein Programm,das ein Datum um eine bestimmte Anzahl von Tagen in die Zukunft oder Vergangenheit verschiebt und das Ergebnis anzeigt.

public class Datum2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss");

        System.out.println(now.format(df));
        System.out.println(now.plusDays(4).format(df));
        System.out.println(now.minusHours(45).format(df));
    }
}
