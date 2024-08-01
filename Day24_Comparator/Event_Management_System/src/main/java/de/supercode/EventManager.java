package de.supercode;

import java.time.LocalDate;
import java.util.*;

public class EventManager {
//    HashMap to store events by date:
    private TreeMap<LocalDate, HashSet<Event>> eventsMapByDate;
//    nested HashMap to manage participants and their roles for a specific event:
    private TreeMap<String, TreeMap<String, HashSet<Role>>> eventsMapByNameAndPartecipants;

    Comparator<Event> dateEventComparator = Comparator.comparing(Event::getEventDate);


    public EventManager() {
        eventsMapByDate = new TreeMap<>();
        eventsMapByNameAndPartecipants = new TreeMap<>();
    }

    public void addEvent(Event event) {
        if (event == null) throw new IllegalArgumentException("Event is null");

        eventsMapByNameAndPartecipants.put(event.getEventName(), new TreeMap<>());
        if (eventsMapByDate.get(event.getEventDate()) == null) eventsMapByDate.put(event.getEventDate(), new HashSet<>(List.of(event)));
        else eventsMapByDate.get(event.getEventDate()).add(event);

    }

    public void addEventParticipant(Person participant, HashSet<Role> roles, Event event) {
        if (participant == null) throw new IllegalArgumentException("No participant selected");
        if (roles.isEmpty()) throw new IllegalArgumentException("Give a real role");
        boolean eventIsRegistred = eventsMapByDate.get(event.getEventDate()).contains(event);
        boolean participantIsNotEnrolledYet = !event.getPartecipants().contains(participant);

        if(eventIsRegistred) {
            if (participantIsNotEnrolledYet) {
                event.addParticipant(participant);
                eventsMapByNameAndPartecipants.get(event.getEventName()).put(participant.getName(), roles);
            }
        }
    }

    public void getParticipantsByEvent(Event event) {
        System.out.println("====================================================================");
        System.out.println("List of participant for the event " + event.getEventName() + ":");
        if (!eventsMapByNameAndPartecipants.get(event.getEventName()).isEmpty()) {
            eventsMapByNameAndPartecipants.get(event.getEventName()).forEach((person, roles) -> System.out.println("\t" + person + " " + roles));
        }
        else {
            System.out.println("\t*+* NO PARTICIPANTS ENROLLED YET *+*");

        }
        System.out.println("====================================================================");
    }

    public void getEventsByDate(LocalDate date) {
        System.out.println("====================================================================");
        System.out.println("List of events for the date " + date + " are the following:");
        if (eventsMapByDate.get(date) != null) {
            List<Map.Entry<LocalDate, HashSet<Event>>> toSort = new ArrayList<>(eventsMapByDate.entrySet());
            eventsMapByDate.get(date).forEach(event -> System.out.println("\t" + event));
        }
        else System.out.println("\t*+*  NONE *+*");
        System.out.println("====================================================================");
    }

    public void getAllEventsbyAllDates() {
        eventsMapByDate.forEach((data, set) ->  getEventsByDate(data));

    }


//    public void removeEventTeilnehmer(Person person, Event event) {
//        if ()
//    }
}
