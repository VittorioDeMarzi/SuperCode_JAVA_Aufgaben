package de.supercode.BootsRental.repositories;


import de.supercode.BootsRental.entities.Boat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoatRepository extends CrudRepository<Boat, Long> {
    List<Boat> findByName(String name);

    List<Boat> findByCategory(String category);

    List<Boat> findBoatsByCapacityGreaterThan(int capacity);
}
