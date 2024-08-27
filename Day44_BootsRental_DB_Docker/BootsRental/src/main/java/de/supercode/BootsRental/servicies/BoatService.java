package de.supercode.BootsRental.servicies;

import de.supercode.BootsRental.entities.Boat;
import de.supercode.BootsRental.repositories.BoatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    BoatRepository boatRepository;

    public BoatService(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    // Post
    public Boat createBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    // get
    public List<Boat> getAllBoat() {
        List<Boat> boats = new ArrayList<>();
        boatRepository.findAll().forEach(boats::add);
        return boats;
    }

    public Optional<Boat> getBoatById(long id) {
        return boatRepository.findById(id);
    }

    public List<Boat> findByName(String name) {
        return boatRepository.searchByName(name);
    }

    // delete
    public void deleteById(long id) {
        boatRepository.deleteById(id);
    }

    // update
    public void updateBoat(long id, Boat newBoat) {
        Boat boat = boatRepository.findById(id).get();
        boat.setCategory(newBoat.getCategory());
        boat.setCapacity(newBoat.getCapacity());
        boat.setName(newBoat.getName());
        boatRepository.save(boat);
    }


}
