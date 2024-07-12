import java.util.ArrayList;

public class Bootsverleih {
    private ArrayList<Boot> boote;
    private ArrayList<Person> kunden;
    // private double umsatz;

    public Bootsverleih() {
        boote = new ArrayList<>();
        kunden = new ArrayList<>();
    }

    public void addBoot(Boot boot) {
        boote.add(boot);
    }

    public void addKunden(Person person) {
        kunden.add(person);
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
}