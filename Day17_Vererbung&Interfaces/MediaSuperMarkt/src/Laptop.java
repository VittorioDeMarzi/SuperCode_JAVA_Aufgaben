public class Laptop extends Geraet implements Internetfaehig {

    private String prozessor;

    public Laptop(String marke, String modell, String prozessor) {
        super(marke, modell);
        this.prozessor = prozessor;
    }

    @Override
    public void verbindenMitInternet() {
        System.out.println("Das Gerät wird mit Internet verbunden.");
    }

    @Override
    public String toString() {
        return "__Laptop__ " + super.toString() +
                ", Prozessor= " + prozessor;
    }
}
