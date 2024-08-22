package de.supercode.Bootsverleih.repositories;

import de.supercode.Bootsverleih.entities.Boat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BoatRepository {
    private static long currentId;
    ArrayList<Boat> boatsDB;

    public BoatRepository() {
        this.boatsDB = new ArrayList<>();
    }

    // create
    public Boat addBoat(Boat boat) {
        boat.setId(currentId++);
        this.boatsDB.add(boat);
        return boatsDB.stream().filter(b -> b==boat).findFirst().orElseThrow();
    }

    // read
    public Boat getBoat(Long id) {
        return boatsDB.stream().filter(b -> b.getId()==id).findFirst().orElseThrow();
    }

    public ArrayList<Boat> getAllBoat() {
        return boatsDB;
    }

    // delete
    public void deleteBoat(long id) {
        this.boatsDB.removeIf(b->b.getId()==id);
    }

    public ArrayList<Boat> getBoatByName(String name) {
        return new ArrayList<>(boatsDB.stream().filter(b-> b.getName().toLowerCase().contains(name.toLowerCase())).toList());
    }


    public void updateBoat(long id, Boat newBoat) {
        newBoat.setId(id);
    }
}
