package Auto1;

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
        car.setKm(car.getKm() + kilometers);
    }
}
