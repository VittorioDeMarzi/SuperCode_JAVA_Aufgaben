
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Bootsverleih shop = new Bootsverleih();
        
        Boot boot1 = new Boot("Segelboot", 0001, 4, false, 20);
        Boot boot2 = new Boot ("Segelboot", 0002, 4, false, 34);
        Boot boot3 = new Boot ("Motorboot", 0003, 2, true, 28);
        Boot boot4 = new Boot ("Segelboot", 0004, 4, true, 20);
        Boot boot5 = new Boot ("Motorboot", 0005, 16, false, 14);
        shop.addBoot(boot1);
        shop.addBoot(boot2);
        shop.addBoot(boot3);
        shop.addBoot(boot4);
        shop.addBoot(boot5);
        
        LocalDateTime samstag12 = LocalDateTime.of(2024, Month.JULY, 13, 12, 0);
        LocalDateTime sonntag11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 0);
        LocalDateTime sonntagNach11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 1);
        LocalDateTime montag12 = LocalDateTime.of(2024, Month.JULY, 15, 12, 0);
        Person andrea = new Person("Andreas", true);
        Person vittorio = new Person("Vittorio", true);
        shop.addKunden(vittorio);
        shop.addKunden(andrea);

        boot3.addReservation(samstag12, sonntag11, andrea);
        
        boot3.addReservation(sonntagNach11, montag12, vittorio);
        boot3.printReservations();

        Boot mostWanted = shop.mostWanted();
        System.out.println(mostWanted.getID());
        
        int mostWantedFromCustumerX = shop.mostWantedFromCustumerX(vittorio);
        System.out.println(mostWantedFromCustumerX);

        Boot lessWanted = shop.lessWanted();
        System.out.println(lessWanted.getID());
    }
}
