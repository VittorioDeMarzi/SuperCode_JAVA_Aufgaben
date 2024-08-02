package de.supercode;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

public class Event {
    private String eventName;
    private LocalDate eventDate;
    private int ageRestriction;
    private HashSet<Person> partecipants;

    public Event(String eventName, LocalDate eventDate, int ageRestriction) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.ageRestriction = ageRestriction;
        this.partecipants = new HashSet<Person>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public HashSet<Person> getPartecipants() {
        return partecipants;
    }

    public void setPartecipants(HashSet<Person> partecipants) {
        this.partecipants = partecipants;
    }

    public void addParticipant(Person person) {
        if(person.getAge() < this.getAgeRestriction()) {
            System.out.println(person + " is to young to take parte to the event. Minimum age is " + this.getAgeRestriction());
            return;
        }
        partecipants.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventName, event.eventName) && Objects.equals(eventDate, event.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventDate);
    }

    @Override
    public String toString() {
        return eventName + ", Age Restriction: " + ageRestriction;
    }

    static Comparator<LocalDate> dateEventComparator = new Comparator<>() {
        @Override
        public int compare (LocalDate o1, LocalDate o2) {
            return o1.compareTo(o2);
        }
    };



}
