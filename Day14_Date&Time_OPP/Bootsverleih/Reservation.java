import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int bootID;
    private Person person;
    private LocalDateTime from;
    private LocalDateTime to;
    private double costOfReservation;

    public Reservation(int ID, Person person, LocalDateTime from, LocalDateTime to) {
        this.bootID = ID;
        this.person = person;
        this.from = from;
        this.to = to;
    }

    public Person getPerson() {
        return person;
    }
    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public int getBootID() {
        return bootID;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEE dd.MM.yyyy HH:mm");
        return "From: " + from.format(f) + " to: " + to.format(f) + " Customer: "
                + person.getName() + ", Licensed: " + person.hasLicence() + ".";
    }
}
