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

    // public Boot mostWantedFromCustumerX() {
        
    //     int counter = 0;
    //     int mostWantedBootID = 0;
    //     ArrayList<Integer> bootsBookedIDs = new ArrayList<>();
    //     for (Reservation reservation : bookingHistoy) 
    //         bootsBookedIDs.add(reservation.getBootID());
    //     bootsBookedIDs.sort(null);
    //     int mostWantedBootID = findMostFrequent(bootsBookedIDs);
    // }

    // private int findMostFrequent(ArrayList<Integer> bootsBookedIDs) {
    //     int currentInt = -1;
    //     int index = 0;
    //     int mostFrequent[][] = 0;
    //     for (int i = 0; i < bootsBookedIDs.size(); i++) {
    //         if (currentInt == bootsBookedIDs.get(i)) {
                
    //         }
    //     }
    // }

}
