package de.supercode.Bootsverleih.entities;

import org.springframework.stereotype.Component;

import java.util.Objects;

public class Boat {
    private long id;
    private String name;
    private String category;
    private int capacity;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return id == boat.id && capacity == boat.capacity && Objects.equals(name, boat.name) && Objects.equals(category, boat.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, capacity);
    }

    @Override
    public String toString() {
        return "Boot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
