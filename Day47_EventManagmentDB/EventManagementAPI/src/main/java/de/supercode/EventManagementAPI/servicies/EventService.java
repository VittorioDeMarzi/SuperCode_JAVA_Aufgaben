package de.supercode.EventManagementAPI.servicies;

import de.supercode.EventManagementAPI.entities.Event;
import de.supercode.EventManagementAPI.entities.Participant;
import de.supercode.EventManagementAPI.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Create
    public Optional<Event> saveNewEvent(Event event) {
        if (eventRepository.findByName(event.getName()).isEmpty())
            return Optional.of(eventRepository.save(event));
        else return Optional.empty();
    }

    // view
    public Optional<List<Event>> findAllEvents() {
        return Optional.of(eventRepository.findAll());
    }

    public Optional<Event> findEventById(long id) {
        return eventRepository.findById(id);
    }

//    public Optional<Event> findEventByName(String name) {
//        return eventRepository.findByName(name);
//    }

    // update
    public Optional<Event> updateEvent(long id, Event newEvent) {
        if (findEventById(id).isPresent()) {
            newEvent.setId(id);
            return saveNewEvent(newEvent);
        } else return Optional.empty();
    }

    public void addParticipantToEvent(long id, Participant participant) {
        Event event = findEventById(id).get();
        event.getParticipants().add(participant);
        eventRepository.save(event);
    }

    // delete
    public Optional<Event> deleteEventById(long id) {
        Optional<Event> eventToDelete = findEventById(id);
        if (eventToDelete.isPresent()) {
            eventRepository.deleteById(id);
        }
        return eventToDelete;
    }
}
