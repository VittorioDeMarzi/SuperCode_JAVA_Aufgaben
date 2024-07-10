package Auto2;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Fiat", "Panda", Year.of(2020));
        
        Driver vittorio = new Driver("Vittorio", "De Marzi", 34);
    
        auto.getDetails();
        auto.refuel(50);
        auto.getDetails();
        vittorio.drive(auto, 100);
        // aldo.drive(auto, 200);
        // vittorio.drive(auto, -1000);
        auto.getDetails();
        vittorio.drive(auto, 345);
        // aldo.drive(auto, 200);
        // vittorio.drive(auto, -1000);
        auto.getDetails();
    }
}
