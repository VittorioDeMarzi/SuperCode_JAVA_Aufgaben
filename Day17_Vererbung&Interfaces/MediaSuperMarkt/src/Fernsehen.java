public class Fernsehen extends Geraet implements Bluetoothfaehig{

    private int Bildschirmgroesse;

    public Fernsehen(String marke, String modell, int bildschirmgroesse) {
        super(marke, modell);
        Bildschirmgroesse = bildschirmgroesse;
    }

    @Override
    public void verbindenMitBloetooth() {
        System.out.println("Das Gerät wird mit einem Bluetooth-Gerät verbunden.");
    }

    @Override
    public String toString() {
        return "__Fernsehen__ " + super.toString() +
                ", Bildschirmgroesse= " + Bildschirmgroesse;
    }
}
