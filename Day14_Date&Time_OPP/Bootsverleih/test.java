import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class test {
    public static void main(String[] args) {
        LocalDateTime pastStart = LocalDateTime.of(2024, Month.JULY, 10, 11, 30);

        Duration duration = Duration.between(LocalDateTime.now(), pastStart);

        System.out.println(duration.toDays());
        System.out.println(duration.toMinutes());
    }
}
