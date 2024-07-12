import java.util.ArrayList;

public class Person {
    private String name;
    private boolean hasLicence;
    private ArrayList<Reservation> bookingHistoy;

    public Person(String name, boolean hasLicence) {
        this.name = name;
        this.hasLicence = hasLicence;
        this.bookingHistoy = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public boolean hasLicence() {
        return this.hasLicence;
    }

    public ArrayList<Reservation> getBookingHistoy() {
        return bookingHistoy;
    }

    public void setBookingHistoy(ArrayList<Reservation> bookingHistoy) {
        this.bookingHistoy = bookingHistoy;
    }

    public void addReservationInBookingHistoy(Reservation reservation) {
        this.bookingHistoy.add(reservation);
    }

}
