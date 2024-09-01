package de.supercode.EventManagementAPI.controllers;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.servicies.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/events/{eventId}/participants")
public class participantControllers {

    ParticipantService participantService;

    public participantControllers(ParticipantService participantService) {
        this.participantService = participantService;
    }

    // Add a new participant to an event.
    @PostMapping
    public ResponseEntity<Event> addParticipantToEvent(@PathVariable long eventId, @RequestBody Participant participant) {
        Optional<Event> event = participantService.addParticipantToEvent(eventId, participant);
        if(event.isPresent()) return new ResponseEntity<>(event.get(), HttpStatus.CREATED);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Edit the participation confirmation of a participant.
    @PutMapping("/{participantId}")
    public ResponseEntity<Event> editConfirmationParticipant(@PathVariable long eventId,@PathVariable long participantId) {
        Optional<Event> editConfirmation = participantService.editConfirmationParticipant(eventId, participantId);
        if (editConfirmation.isPresent()) return new ResponseEntity<>(editConfirmation.get(),HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    // List all participants of an event.
    @GetMapping
    public ResponseEntity<List<Participant>> getParticipantsOneEvent(@PathVariable long eventId) {
        Optional<List<Participant>> participantsOneEvent = participantService.getParticipantsOneEvent(eventId);
        if (participantsOneEvent.isPresent()) return new ResponseEntity<>(participantsOneEvent.get(), HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //  Remove a participant from an event.
    @DeleteMapping("/{participantId}")
    public ResponseEntity<Event> removeParticipantFromEvent(@PathVariable long eventId, @PathVariable long participantId) {
        Optional<Event> event = participantService.removeParticipantFromEvent(eventId, participantId);
        if (event.isPresent()) return new ResponseEntity<>(event.get(), HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
