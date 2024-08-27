package de.supercode.BootsRental.controller;

import de.supercode.BootsRental.entities.Boat;
import de.supercode.BootsRental.errors.ApiError;
import de.supercode.BootsRental.servicies.BoatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boats")
public class BoatController {
    BoatService boatService;

    public BoatController(BoatService boatService) {
        this.boatService = boatService;
    }

    // post
    @PostMapping("")
    public Boat createBoat(@RequestBody Boat boat) {
        return boatService.createBoat(boat);
    }

    // get
    @GetMapping("")
    public List<Boat> getAllBoats() {
        return boatService.getAllBoat();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoatById(@PathVariable long id) {
        Optional<Boat> boat = boatService.getBoatById(id);
        if (boat.isEmpty()) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Boat with id:"+ id + " not found!!"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(boat,HttpStatus.FOUND);
    }

    @GetMapping("/boat/{name}")
    public List<Boat> findByName(@PathVariable String name) {
        System.out.println(name);
        return boatService.findByName(name);
    }

    // delete
    @DeleteMapping("/boat/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
       Optional<Boat> boat = boatService.getBoatById(id);
        if (boat.isEmpty()) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Boat with id:"+ id + " not found!!"), HttpStatus.NOT_FOUND);
        else {
            boatService.deleteById(id);
            return new ResponseEntity<>(boat,HttpStatus.GONE);
        }
    }

    // Put
    @PutMapping("/boat/{id}")
    public ResponseEntity<?> updateBoat(@PathVariable long id, @RequestBody Boat newBoat) {
        Optional<Boat> boat = boatService.getBoatById(id);
        if (boat.isEmpty()) return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Boat with id:"+ id + " not found!!"), HttpStatus.NOT_FOUND);
        else {
            boatService.updateBoat(id, newBoat);
            return new ResponseEntity<>(boat,HttpStatus.GONE);
        }
    }

 }
