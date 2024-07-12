import java.time.LocalDateTime;
import java.time.chrono.ThaiBuddhistDate;
import java.util.ArrayList;

public class Boot {
    // länge, breite, tiefgang, freiboard
    // hasMotor: segelboot (masthöhe) vs. motorboot
    // personCount
    // isLicenceRequired 
    // availability: Reservation[] from, to, person
    private int ID;
    private String type; // Segelboot | Motorboot
    private int personCount;
    private boolean isLicenceRequired;
    private double pricePerHour;
    private ArrayList<Reservation> reservations;

    public Boot(String type, int ID, int personCount, boolean isLicenceRequired, double pricePerHour) {
        this.setID(ID);
        this.setType(type);
        this.setPersonCount(personCount);
        this.setIsLicenceRequired(isLicenceRequired);
        this.setPricePerHour(pricePerHour);
        this.reservations = new ArrayList<Reservation>();
    }

    private void setID(int ID) {
        if (ID < 0)
            throw new IllegalArgumentException("Invalid ID");
        this.ID = ID;
    }

    public void setType(String type) {
        if(!type.equals("Segelboot") && !type.equals("Motorboot")) throw new IllegalArgumentException("Bootstyp muss Segelboot oder Motorboot sein");
        this.type = type;
    }
    public void setPersonCount(int personCount) {
        if(personCount <= 0) throw new IllegalArgumentException("Personcount muss größer als 0 sein");
        this.personCount = personCount;
    }
    public void setIsLicenceRequired(boolean isLicenceRequired) {
        this.isLicenceRequired = isLicenceRequired;
    }

    public void setPricePerHour(double pricePerHour) {
        if (pricePerHour < 0.0)
            throw new IllegalArgumentException("Personcount muss positiv sein");
        this.pricePerHour = pricePerHour;
    }
    
    public int getID() {
        return this.ID;
    }

    public String getType() {
        return type;
    }
    public int getPersonCount() {
        return personCount;
    }
    public boolean isLicenceRequired() {
        return isLicenceRequired;
    }
    public double getPicePerHour() {
        return pricePerHour;
    }
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Reservation addReservation(LocalDateTime from, LocalDateTime to, Person p) {
        boolean licenceOK = !isLicenceRequired || isLicenceRequired && p.hasLicence(); 
        if(!licenceOK) throw new IllegalStateException("Licence required to book this boat");

        // check availability based on from and to values!!!
        boolean isAvailable = checkAvailability(from, to);
        if(!isAvailable) throw new IllegalStateException("Boat not available, please try a different time");
        
        Reservation reservation = new Reservation(this.ID, p, from, to);
        reservations.add(reservation);
        p.addReservationInBookingHistoy(reservation);
        return reservation;
    }
 
    private boolean checkAvailability(LocalDateTime from, LocalDateTime to) {
        for (Reservation booking : reservations) {
            if (beginRentalIsNotPossible(from, booking) || endRentalIsNotPossible(to, booking)) {
                return false;
            }
        }
        return true;
    }

    private boolean beginRentalIsNotPossible(LocalDateTime from, Reservation booking) {
        return from.isAfter(booking.getFrom()) && from.isBefore(booking.getFrom());
    }
    
    private boolean endRentalIsNotPossible(LocalDateTime to,  Reservation booking) {
        return to.isAfter(booking.getFrom()) && to.isBefore(booking.getFrom());
    }

    public void printReservations() {
        
        System.out.println("Reservation of: " + this.type);
        for (Reservation booking : reservations)
            System.out.println("\t" + booking.toString());
    }
}
