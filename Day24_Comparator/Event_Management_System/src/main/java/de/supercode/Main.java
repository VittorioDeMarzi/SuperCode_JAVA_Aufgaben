package de.supercode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EventManager eventManager = new EventManager();

        LocalDate event1Date = LocalDate.of(2024, 6, 15);

        // Create events with dates and age limits
        Event event1 = new Event("Summer Festival", event1Date, 12);
        Event event2 = new Event("Tech Conference", LocalDate.of(2024, 9, 20), 18);
        Event event3 = new Event("Art Exhibition", LocalDate.of(2024, 7, 25), 16);
        Event event4 = new Event("JAVA Workshop", LocalDate.of(2024, 9, 25), 18);
        Event event5 = new Event("Yoga Retrieve", event1Date, 12);
        Event event6 = new Event("Meditation Workshop", event1Date, 12);

        // Collect all events in a list
        ArrayList<Event> allEvents = new ArrayList<>(List.of(event1, event2, event3, event4, event5, event6));

        // Create participants with birth dates
        Person person1 = new Person("Alice Smith", LocalDate.of(2015, 5, 15));
        Person person2 = new Person("Bob Johnson", LocalDate.of(1985, 8, 22));
        Person person3 = new Person("Charlie Brown", LocalDate.of(2000, 1, 10));
        Person person4 = new Person("Diana Prince", LocalDate.of(1992, 11, 3));
        Person person5 = new Person("Edward Black", LocalDate.of(1978, 6, 29));
        Person person6 = new Person("Fiona White", LocalDate.of(1995, 12, 25));
        Person person7 = new Person("George Miller", LocalDate.of(1988, 4, 8));
        Person person8 = new Person("Hannah Green", LocalDate.of(2002, 7, 18));
        Person person9 = new Person("Ian Wright", LocalDate.of(1982, 9, 5));
        Person person10 = new Person("Jane Doe", LocalDate.of(1996, 2, 14));

        // Add events to the event manager
        eventManager.addEvent(event1);
        eventManager.addEvent(event2);
        eventManager.addEvent(event3);
        eventManager.addEvent(event4);
        eventManager.addEvent(event5);
        eventManager.addEvent(event6);

        // Add participants to events
//      Person1 should be too young to participate
        eventManager.addEventParticipant(person1, new HashSet<>(Set.of(Role.SPEAKER)), event1);
        eventManager.addEventParticipant(person2, new HashSet<>(Set.of(Role.STARGUEST)), event2);
        eventManager.addEventParticipant(person3, new HashSet<>(Set.of(Role.ATTENDEE)), event3);
        eventManager.addEventParticipant(person4, new HashSet<>(Set.of(Role.VOLUNTEER)), event1);
        eventManager.addEventParticipant(person5, new HashSet<>(Set.of(Role.SPEAKER, Role.VOLUNTEER)), event2);
        eventManager.addEventParticipant(person6, new HashSet<>(Set.of(Role.STARGUEST)), event3);
        eventManager.addEventParticipant(person7, new HashSet<>(Set.of(Role.ATTENDEE)), event1);
        eventManager.addEventParticipant(person8, new HashSet<>(Set.of(Role.VOLUNTEER)), event2);
        eventManager.addEventParticipant(person9, new HashSet<>(Set.of(Role.SPEAKER)), event1);
        eventManager.addEventParticipant(person10, new HashSet<>(Set.of(Role.STARGUEST)), event5);

        // Print partecipant by event
        eventManager.getParticipantsByEvent(event1);
//        eventManager.getParticipantsByEvent(event4);
//        eventManager.getParticipantsByEvent(event5);

        // * print participants for all events
        allEvents.forEach(eventManager::getParticipantsByEvent);

        //  * print event by date
        eventManager.getEventsByDate(event1Date);

        //  * Print events for every date
//        They are printed in chronological order according to the event dates
        eventManager.getAllEventsbyAllDates();

//        eventManager.removeEventTeilnehmer(person4, event1);
    }

}