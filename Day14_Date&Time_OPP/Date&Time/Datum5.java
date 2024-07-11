
import java.time.LocalDateTime;

// # 5. **Wochentag eines bestimmten Datums ermitteln**

// Schreibe ein Programm, das den Wochentag eines bestimmten Datums ermittelt.

public class Datum5 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek());
    }
}
