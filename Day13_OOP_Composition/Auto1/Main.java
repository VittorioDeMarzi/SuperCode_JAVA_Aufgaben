package Auto1;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Fiat", Year.of(2020), 20000);
        Driver vittorio = new Driver("Vittorio", "De Marzi", 34);
        Driver aldo = new Driver("Aldo", "Baglio", 17);
    
        auto.getDetails();
        vittorio.drive(auto, 100);
        // aldo.drive(auto, 200);
        // vittorio.drive(auto, -1000);
        auto.getDetails();


    }
}
