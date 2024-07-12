import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class Bootsverleih {
    private String name;
    private ArrayList<Boot> boote;
    private ArrayList<Person> kunden;
    private double revenue;

    public Bootsverleih(String name) {
        this.name = name;
        this.boote = new ArrayList<>();
        this.kunden = new ArrayList<>();
        this.revenue = 0;
    }

    public void addBoot(Boot boot) {
        boote.add(boot);
    }

    public void addKunden(Person person) {
        kunden.add(person);
    }

    public String getName() {
        return name;
    }


    // the customer with the most reservation (count)
    public Person topCustomer() {
        if (kunden.isEmpty())
            throw new IllegalStateException("Client list is still empty");
        int maxNumReservations = 0;
        Person bestKunde = kunden.get(0);
        for (Person kunde : kunden) {
            if (kunde.getBookingHistoy().size() > maxNumReservations)
                bestKunde = kunde;
        }
        return bestKunde;
    }

    public Boot mostWanted() {
        if (boote.isEmpty())
            throw new IllegalStateException("No boots listed yet");
        int counter = 0;
        Boot mostWanted = boote.get(0);
        for (Boot boot : boote) {
            if (boot.getReservations().size() > counter) {
                mostWanted = boot;
            }
        }
        return mostWanted;
    }
    
    public double getRevenue() {
        return revenue;
    }

    public void increaseRevenue(double priceReservation) { // revenue will increase by timeReservation * pricePerHour;
        this.revenue += revenue;
    }

    public int mostWantedFromCustumerX(Person person) {
        if (boote.isEmpty())
            throw new IllegalStateException("No boots listed yet.");
        if (person.getBookingHistoy().isEmpty())
            throw new IllegalStateException("Custumer has never done a reservation yet.");
        int mostBookedBootID = 0;
        int counterMostWanted = 0;
        for (Boot boot : boote) {
            int counter = 0;
            for (Reservation booking : boot.getReservations()) {
                if (person.getName().equals(booking.getPerson().getName()))
                    counter++;
            }
            if (counter > counterMostWanted) {
                mostBookedBootID = boot.getID();
            }
        }
        return mostBookedBootID;
    }

    public Boot lessWanted() {
        if (boote.isEmpty())
            throw new IllegalStateException("No boots listed yet");
        int counter = boote.get(0).getReservations().size();
        Boot lessWanted = boote.get(0);
        for (Boot boot : boote) {
            if (boot.getReservations().size() < counter) {
                lessWanted = boot;
            }
        }
        return lessWanted;
    }

    public void addReservation(Boot boot, LocalDateTime starTime, LocalDateTime endTime, Person andrea) {
        boot.addReservation(starTime, endTime, andrea);
        increaseRevenue(boot, starTime, endTime);
    }

    public void increaseRevenue(Boot boot, LocalDateTime starTime, LocalDateTime endTime) {
        Duration durationReservation = Duration.between(starTime, endTime);
        double costOfReservation = durationReservation.toMinutes() * (boot.getPicePerHour() / 60);
        this.revenue += costOfReservation;
    }

    public void printReservations(Boot boot) {
        // System.out.printf("Reservation boat %s:%n", boot.getID());
        boot.printReservations();
    }

    public void printReservations() {
        for (Boot boot : boote)
            this.printReservations(boot);
    }

    public void printRevenue() {
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.printf("%s - Revenue: %s.%n", this.name, nf.format(this.revenue));
    }


}