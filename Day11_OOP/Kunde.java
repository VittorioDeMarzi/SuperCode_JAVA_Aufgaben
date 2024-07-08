public class Kunde {
    private String kundenID;
    private String name;
    private String email;
    private String telefonnummer;

    public Kunde(String email, String kundenID, String name, String telefonnummer) {
        this.email = email;
        this.kundenID = kundenID;
        this.name = name;
        this.telefonnummer = telefonnummer;
    }

    public String getKundenID() {
        return kundenID;
    }

    public void setKundenID(String kundenID) {
        this.kundenID = kundenID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void printDetails() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Kunde: " +
                "kundenID= '" + kundenID +
                ", name= '" + name +
                ", email= '" + email +
                ", telefonnummer= '" + telefonnummer;
    }
  
}
