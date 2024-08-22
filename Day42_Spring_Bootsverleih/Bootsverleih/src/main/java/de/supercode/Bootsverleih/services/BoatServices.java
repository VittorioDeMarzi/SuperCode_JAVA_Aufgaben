package de.supercode.Bootsverleih.services;

import de.supercode.Bootsverleih.entities.Boat;
import de.supercode.Bootsverleih.repositories.BoatRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoatServices {
    BoatRepository boatRepository;

    public BoatServices(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    public void addBoat(Boat boat){
        boatRepository.addBoat(boat);
    }

    public ArrayList<Boat> getAllBoats() {
        return boatRepository.getAllBoat();
    }

    public Boat getBoat(long id) {
        return boatRepository.getBoat(id);
    }

    public void deleteBoat(long id) {
        boatRepository.deleteBoat(id);
    }

    public ArrayList<Boat> getBoatByName(String name) {
        return boatRepository.getBoatByName(name);
    }

    public void updateBoat(long id, Boat newBoat) {
        boatRepository.updateBoat(id, newBoat);
    }
}
