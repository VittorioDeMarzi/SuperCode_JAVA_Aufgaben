package de.supercode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Objects;

public class Person {
    private String name;
    private LocalDate DOB;

    public Person(String name, LocalDate DOB) {
        this.name = name;
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return name + ", DOB=" + DOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(DOB, person.DOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, DOB);
    }

    public int getAge() {
        Period per = Period.between(this.DOB, LocalDate.now());
        return per.getYears();
    }

    Comparator<Person> nameComparator = Comparator.comparing(Person::getName);

}
