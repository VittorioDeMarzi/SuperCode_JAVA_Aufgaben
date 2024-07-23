public class Smartphone extends Geraet implements Internetfaehig, Bluetoothfaehig {

    private String betriebsystem;

    public Smartphone(String marke, String modell, String betriebsystem) {
        super(marke, modell);
        this.betriebsystem = betriebsystem;
    }

    @Override
    public void verbindenMitInternet() {
        System.out.println("Das Gerät wird mit Internet verbunden.");
    }

    @Override
    public void verbindenMitBloetooth() {
        System.out.println("Das Gerät wird mit einem Bluetooth-Gerät verbunden.");
    }

    @Override
    public String toString() {
        return "__Smartphone__ "  + super.toString() +
                ", Betriebsystem= " + betriebsystem;
    }


}
