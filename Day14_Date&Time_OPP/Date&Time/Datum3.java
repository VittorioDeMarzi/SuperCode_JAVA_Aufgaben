// # 3. **Alter berechnen:**

// Schreibe ein Programm, das das Alter einer Person basierend auf ihrem Geburtsdatum berechnet.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datum3 {
    public static void main(String[] args) {
        LocalDateTime DOB = LocalDateTime.of(1990, 1, 30, 14, 00);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss");
        
        System.out.println(DOB.format(df));
        int age = LocalDateTime.now().compareTo(DOB);
        System.out.println(age);
    }
}
