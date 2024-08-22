package de.supercode.Bootsverleih.controller;

import de.supercode.Bootsverleih.entities.Boat;
import de.supercode.Bootsverleih.services.BoatServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/boats")
public class BoatController {
    BoatServices boatServices;

    public BoatController(BoatServices boatServices) {
        this.boatServices = boatServices;
    }

    // Get
    @GetMapping
    public ArrayList<Boat> getAllBoat(){
        return boatServices.getAllBoats();
    }

    @GetMapping("/boat")
    public Boat getBoatRequestParam(@RequestParam long id){
        return boatServices.getBoat(id);
    }

    @GetMapping("/boat/{id}")
    public Boat getBoatPathVariable(@PathVariable long id) {
        return boatServices.getBoat(id);
    }

    // Get searching per name
    @GetMapping("/search")
    public ArrayList<Boat> getBoatByName(@RequestParam String name) {
        return boatServices.getBoatByName(name);
    }

    // Post
    @PostMapping
    public void addBoat(@RequestBody Boat boat) {
        boatServices.addBoat(boat);
    }

    // delete
    @DeleteMapping("/boat")
    public void deleteBoatRequestParam(@RequestParam long id) {
        boatServices.deleteBoat(id);
    }

    @DeleteMapping("/boat/{id}")
    public void deleteBoatPathVariable(@PathVariable long id) {
        boatServices.deleteBoat(id);
    }

    // update
   @PutMapping("/boat/{id}")
    public void updateBoat(@PathVariable long id, @RequestBody Boat newBoat) {
        boatServices.getBoat(id).setName(newBoat.getName());
        boatServices.getBoat(id).setCategory(newBoat.getCategory());
        boatServices.getBoat(id).setCapacity(newBoat.getCapacity());
    }
}
