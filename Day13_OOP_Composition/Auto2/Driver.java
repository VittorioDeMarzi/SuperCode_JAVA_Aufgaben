package Auto2;

public class Driver {
    private String firstName;
    private String lastName;
    private int age;

    public Driver(String firstName, String lastName,int age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Implement a method drive(Car car, int kilometers) that allows a driver to drive a car for a specified number of kilometers. Increase the car's mileage by the given value. 
    public void drive(Auto car, int kilometers) {
        if (kilometers <= 0)
            throw new IllegalArgumentException("Value of Km not valid");
        if (this.age < 18)
            throw new IllegalStateException("Driver is under 18 years old. Drive not allowed.");
        increaseKm(car, kilometers);
        decreaseTankContent(car, kilometers);
        car.setRangeKmPossible();
    }

    private void increaseKm(Auto car, int kilometers) {
        car.setKm(car.getKm() + kilometers);
    }

    private void decreaseTankContent(Auto car, int kilometers) {
        double consumed = car.getConsumption() * kilometers;
    
        if (consumed > car.getTankContent())
            throw new IllegalStateException("Fuel is not enough for the ride. Refuel.");
        car.setTankContent(car.getTankContent() - consumed);
    }
    


}
