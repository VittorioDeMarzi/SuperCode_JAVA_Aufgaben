package de.supercode.EventManagementAPI.servicies;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    ParticipantRepository participantRepository;
    EventService eventService;

    public ParticipantService(ParticipantRepository participantRepository, EventService eventService) {
        this.participantRepository = participantRepository;
        this.eventService = eventService;
    }

    // Add participants to an event.
    public Optional<Event> addParticipantToEvent (long id, Participant participant) {
        Optional<Event> eventById = eventService.findEventById(id);
        if(eventById.isPresent()) {
            participantRepository.save(participant);
            eventService.addParticipantToEvent(id, participant);

        }
        return eventById;
    }

    // Edit the participation confirmation of a participant.
    public Optional<Event> editConfirmationParticipant(long eventId, long participantId) {
        Optional<Participant> participantById = participantRepository.findById(participantId);
        Optional<Event> eventById = eventService.findEventById(eventId);

        if (eventById.isPresent() && participantById.isPresent()) {
            if (eventById.get().getParticipants().contains(participantById.get())) {
                participantById.get().setConfirmed(true);
                participantRepository.save(participantById.get());
                return eventById;
            }
        }
        return Optional.empty();
    }

    // List all participants of an event.
    // Frage. Se ritorno l'Optional della lista vuota.. È un optional null?
    public Optional<List<Participant>> getParticipantsOneEvent(long id) {
        Optional<Event> eventById = eventService.findEventById(id);
        if (eventById.isPresent()) {
            return Optional.of(eventById.get().getParticipants());
        } else return Optional.empty();
    }

    //  Remove a participant from an event.
    public Optional<Event> removeParticipantFromEvent(long eventId, long participantId) {
        Optional<Participant> participantById = participantRepository.findById(participantId);
        Optional<Event> eventById = eventService.findEventById(eventId);

        if (eventById.isPresent() && participantById.isPresent()) {
           if (eventById.get().getParticipants().remove(participantById.get())) {
               participantRepository.delete(participantById.get());
               eventService.saveNewEvent(eventById.get());
               return eventById;
           }
        }
        return Optional.empty();
    }
}
