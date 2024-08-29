package de.supercode.Friends.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long Id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate birthDate;
    @Column
    private String phonNumber;
    @Column
    private String email;
    @Column
    private String occupation;
    @Column
    private long income;
    @Column
    private Boolean isSelfEmployed;
    @Column
    private Boolean hasBeenCustomerBefore;

    @JsonIgnoreProperties("friends")
    @ManyToOne
    private Category category;

    public long getId() { return Id; }

    public void setId(long id) { Id = id; }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public Boolean getSelfEmployed() {
        return isSelfEmployed;
    }

    public void setSelfEmployed(Boolean selfEmployed) {
        isSelfEmployed = selfEmployed;
    }

    public Boolean getHasBeenCustomerBefore() {
        return hasBeenCustomerBefore;
    }

    public void setHasBeenCustomerBefore(Boolean hasBeenCustomerBefore) {
        this.hasBeenCustomerBefore = hasBeenCustomerBefore;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Id == friend.Id && Objects.equals(firstName, friend.firstName) && Objects.equals(lastName, friend.lastName) && Objects.equals(birthDate, friend.birthDate) && Objects.equals(phonNumber, friend.phonNumber) && Objects.equals(email, friend.email) && Objects.equals(occupation, friend.occupation) && Objects.equals(income, friend.income) && Objects.equals(isSelfEmployed, friend.isSelfEmployed) && Objects.equals(hasBeenCustomerBefore, friend.hasBeenCustomerBefore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, birthDate, phonNumber, email, occupation, income, isSelfEmployed, hasBeenCustomerBefore);
    }
}
