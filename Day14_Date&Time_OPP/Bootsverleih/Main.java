
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Bootsverleih spreeRental = new Bootsverleih("Spree Rental");
        
        Boot boot1 = new Boot("Segelboot", 0001, 4, false, 20);
        Boot boot2 = new Boot ("Segelboot", 0002, 4, false, 34);
        Boot boot3 = new Boot ("Motorboot", 0003, 2, true, 28);
        Boot boot4 = new Boot ("Segelboot", 0004, 4, true, 20);
        Boot boot5 = new Boot ("Motorboot", 0005, 16, false, 14);
        spreeRental.addBoot(boot1);
        spreeRental.addBoot(boot2);
        spreeRental.addBoot(boot3);
        spreeRental.addBoot(boot4);
        spreeRental.addBoot(boot5);
        
        LocalDateTime samstag12 = LocalDateTime.of(2024, Month.JULY, 13, 12, 0);
        LocalDateTime sonntag11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 0);
        LocalDateTime sonntagNach11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 1);
        LocalDateTime montag12 = LocalDateTime.of(2024, Month.JULY, 15, 12, 0);
        LocalDateTime secondNovember = LocalDateTime.of(2024, Month.NOVEMBER, 02, 11, 30);
        LocalDateTime fourthNovember = LocalDateTime.of(2024, Month.NOVEMBER, 04, 12, 0);
        Person andrea = new Person("Andreas", true);
        Person vittorio = new Person("Vittorio", true);
        Person aldo = new Person("Aldo", true);
        spreeRental.addKunden(vittorio);
        spreeRental.addKunden(andrea);
        spreeRental.addKunden(andrea);

        spreeRental.printRevenue();
        spreeRental.addReservation(boot3, samstag12, sonntag11, andrea);
        spreeRental.addReservation(boot3, sonntagNach11, montag12, vittorio);
        spreeRental.addReservation(boot2, sonntagNach11, montag12, vittorio);
        spreeRental.printRevenue();
        spreeRental.addReservation(boot2, secondNovember, fourthNovember, vittorio);
        spreeRental.addReservation(boot4, sonntagNach11, montag12, aldo);
        spreeRental.printRevenue();
        
        spreeRental.printReservations();

        Boot mostWanted = spreeRental.mostWanted();
        System.out.printf("The most wanted Boat in %s is ID: %s.%n", spreeRental.getName(), mostWanted.getID());
        
        int mostWantedFromCustumerX = spreeRental.mostWantedFromCustumerX(vittorio);
        System.out.printf("The most booked Boot from %s in %s is ID: %s.%n", vittorio.getName(), spreeRental.getName(), mostWantedFromCustumerX);

        Boot lessWanted = spreeRental.lessWanted();
        System.out.printf("The less wanted Boot in %s is ID: %s.%n", spreeRental.getName(), lessWanted.getID());
        
        int lastNDays = 10;

        LocalDateTime pastStart = LocalDateTime.of(2024, Month.JULY, 10, 11, 30);
        LocalDateTime pastTo = LocalDateTime.of(2024, Month.JULY, 11, 23, 0);
        spreeRental.addReservation(boot2, pastStart, pastTo, vittorio);

        Boot boatWithHighestRevenueInLastNDays = spreeRental.boatWithHighestRevenue(lastNDays);
        System.out.printf("The boat with the highest income is ID: %s with a income of € %s.%n", boatWithHighestRevenueInLastNDays.getID(), boatWithHighestRevenueInLastNDays.incomeBootLastNdays(lastNDays));
        
    }
}
