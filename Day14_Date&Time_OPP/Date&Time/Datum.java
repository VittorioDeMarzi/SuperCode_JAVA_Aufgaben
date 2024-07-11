
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// # 1. **Aktuelles Datum und Uhrzeit:**

// Schreibe ein Programm, das das aktuelle Datum und die aktuelle Uhrzeit in verschiedenen Formaten ausgibt.

public class Datum {
    public static void main(String[] args) {
    
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df1 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("EEE, d MMM yyyy, HH:mm:ss");
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("dd/dd/yy, HH:mm:ss");
        DateTimeFormatter df4 = DateTimeFormatter.ofPattern("yyy-MM-dd");

    System.out.println(now);
    System.out.println(now.format(df1));
    System.out.println(now.format(df2));
    System.out.println(now.format(df3));
    System.out.println(now.format(df4));
}
}