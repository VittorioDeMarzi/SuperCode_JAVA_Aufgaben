public class Geraet {
    private String marke;
    private String modell;

    public Geraet(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
    }

    public void einschalten(){
        System.out.println("Das Gerät wird eingeschaltet!");
    }

    public void ausschalten(){
        System.out.println("Das Gerät wird ausgeschaltet!");
    }

    public void anzeigen(){
        System.out.println(this.toString());
    }

    public void testGereat(Geraet gereat) {
        einschalten();
        anzeigen();
        ausschalten();
    }

    @Override
    public String toString() {
        return "marke= " + marke +
                ", modell= " + modell;
    }
}
