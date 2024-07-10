package Auto2;

import java.time.Year;

public class Auto {
    private String brand;
    private String model;
    private Year year;
    private int km;

    private double tankCapacity; // maximum tank capacity of the car in liters
    private double tankContent; // current tank content of the car in liters
    private double consumption; // stores the liters consumed per kilometer
    private int rangeKmPossible;

    public Auto(String brand, String model, Year year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = 0;
        this.tankCapacity = 50.0;
        this.tankContent = 0;
        this.consumption = 0.07;
        this.rangeKmPossible = 0;
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
    
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public double getTankCapacity() {
        return tankCapacity;
    }
    
    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    
    public double getTankContent() {
        return tankContent;
    }
    
    public void setTankContent(double tankContent) {
        this.tankContent = tankContent;
    }
    
    public double getConsumption() {
        return consumption;
    }
    
    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void getDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Brand: " + brand +
                " - Model: " + model +
                " - Year: " + year +
                " - Km: " + km + 
                "\n Tank Content: " + tankContent + 
                " - Range Km Possible: " + rangeKmPossible;
    }
    
    public void refuel(double liters) {
        if (liters + this.tankContent > this.tankCapacity)
            throw new IllegalStateException("Too many liters of fuel wanted");
        this.setTankContent(liters + this.tankContent);
        setRangeKmPossible();
    }

    public void checkService() {
        if (this.km > 15000) System.out.println("15000Km exeeded. Service is required");
    }

    public void setRangeKmPossible() {
        int range = (int)(this.tankContent / this.consumption);
        this.rangeKmPossible = range;
    }

    public int getRangeKmPossible() {
        return rangeKmPossible;
    }

}