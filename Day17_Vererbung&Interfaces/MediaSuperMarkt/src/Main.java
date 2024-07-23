import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Laptop laptop = new Laptop("Apple", "Air", "M2");
        Fernsehen tv = new Fernsehen("Samsung", "T2", 55);
        Smartphone phone = new Smartphone("Apple", "Iphone 15", "IOS");

        laptop.verbindenMitInternet();
        tv.verbindenMitBloetooth();
        phone.verbindenMitInternet();

        ArrayList<Geraet> geraets = new ArrayList<>(List.of(laptop, tv, phone));

        for (Geraet geraet : geraets) {
            geraet.anzeigen();
        }
    }
}
