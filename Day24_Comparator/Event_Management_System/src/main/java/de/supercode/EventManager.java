package de.supercode;

import java.time.LocalDate;
import java.util.*;

public class EventManager {
//    HashMap to store events by date:
    private HashMap<LocalDate, HashSet<Event>> eventsMapByDate;
//    nested HashMap to manage participants and their roles for a specific event:
    private HashMap<String, HashMap<String, HashSet<Role>>> eventsMapByNameAndPartecipants;

    Comparator<Event> dateEventComparator = Comparator.comparing(Event::getEventDate);


    public EventManager() {
        eventsMapByDate = new HashMap<>();
        eventsMapByNameAndPartecipants = new HashMap<>();
    }

    public void addEvent(Event event) {
        if (event == null) throw new IllegalArgumentException("Event is null");

        eventsMapByNameAndPartecipants.put(event.getEventName(), new HashMap<>());
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
        System.out.println("List of participant for the event " + event.getEventName() + " [Date: " + event.getEventDate() +  "]:");
        if (!eventsMapByNameAndPartecipants.get(event.getEventName()).isEmpty()) {
            eventsMapByNameAndPartecipants.get(event.getEventName()).forEach((person, roles) -> System.out.println("\t" + person + " " + roles));
        }
        else {
            System.out.println("\t*+* NO PARTICIPANTS ENROLLED YET *+*");

        }
    }

    public void getEventsByDate(LocalDate date) {
        System.out.println("====================================================================");
        System.out.println("" + date + ":");
        if (eventsMapByDate.get(date) != null) {
            eventsMapByDate.get(date).forEach(event -> System.out.println("\t" + event));
        }
        else System.out.println("\t*+*  NONE *+*");
    }

    public void getAllEventsbyAllDates() {
        System.out.println("***** EVENT LIST FOR ALL DATES *****");
        List<LocalDate> toSort = new ArrayList<>(eventsMapByDate.keySet());
        toSort.sort(Event.dateEventComparator);
        toSort.forEach(this::getEventsByDate);

    }


//    public void removeEventTeilnehmer(Person person, Event event) {
//        if ()
//    }
}
