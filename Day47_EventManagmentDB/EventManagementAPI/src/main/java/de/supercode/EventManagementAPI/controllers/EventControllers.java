package de.supercode.EventManagementAPI.controllers;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.servicies.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/events")
public class EventControllers {

    EventService eventService;

    public EventControllers(EventService eventService) {
        this.eventService = eventService;
    }

    // POST
    @PostMapping
    public ResponseEntity<Event> saveNewEvent(@RequestBody Event event) {
        if (eventService.saveNewEvent(event).isEmpty()) return new ResponseEntity<>(event, HttpStatus.ALREADY_REPORTED);
        else return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    // GET all events
    @GetMapping
    public ResponseEntity<List<Event>> findAllEvents() {
        if (eventService.findAllEvents().isPresent()) return new ResponseEntity<>(eventService.findAllEvents().get(), HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // GET event by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> findEventById(@PathVariable long eventId) {
        if (eventService.findEventById(eventId).isPresent()) return new ResponseEntity<>(eventService.findEventById(eventId).get(), HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Update details of an event
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody Event newEvent) {
        if (eventService.updateEvent(id, newEvent).isPresent()) return new ResponseEntity<>(eventService.updateEvent(id, newEvent).get(), HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Delete an event and all participants of the event.
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Event> deleteById(@PathVariable long eventId) {

        Optional<Event> eventToDelete = eventService.deleteEventById(eventId);
        if (eventToDelete.isPresent()) return new ResponseEntity<>(eventToDelete.get(), HttpStatus.GONE);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
