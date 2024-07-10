package Auto1;

import java.time.Year;

public class Auto {
    private String brand;
    private Year year;
    private int km;
    
    public Auto(String brand, Year year, int km) {
        this.brand = brand;
        this.year = year;
        this.km = km;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    
    public void getDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Brand: " + brand + 
                " - Year: " + year + 
                " - Km: " + km;
    }
}