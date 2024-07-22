import java.util.*;

class EventManagementSystem {
    private List<Event> events = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        system.addEvent("Java-Konferenz", new Date(), "Berlin", 100);
        system.addParticipant("Max", "Mustermann", "max@example.com");
        system.registerParticipantToEvent("Java-Konferenz", "max@example.com");
        system.displayEvents();
    }

    public void addEvent(String name, Date date, String location, int maxParticipants) {
        Event event = new Event(name, date, location, maxParticipants);
        events.add(event);
    }

    public void removeEvent(String name) {
        Event toRemove = findEventByName(name);
        if (toRemove != null) {
            events.remove(toRemove);
        }
    }

    public void addParticipant(String firstName, String lastName, String email) {
        Participant participant = new Participant(firstName, lastName, email);
        participants.add(participant);
    }

    public void removeParticipant(String email) {
        Participant toRemove = findParticipantByEmail(email);
        if (toRemove != null) {
            participants.remove(toRemove);
        }
    }

    public void registerParticipantToEvent(String eventName, String participantEmail) {
        Event event = findEventByName(eventName);
        Participant participant = findParticipantByEmail(participantEmail);

        if (event != null && participant != null) {
            if (event.participants.size() < event.maxParticipants) {
                event.participants.add(participant);
            } else {
                System.out.println("Maximale Teilnehmerzahl erreicht");
            }
        }
    }

    public void unregisterParticipantFromEvent(String eventName, String participantEmail) {
        Event event = findEventByName(eventName);

        if (event != null) {
            Participant toRemove = findParticipantByEmail(participantEmail);

            if (toRemove != null) {
                event.participants.remove(toRemove);
            }
        }
    }

    public Event findEventByName(String name) {
        Event toFind = null;
        for (Event event : events) {
            if (event.name.equals(name)) {
                toFind = event;
                break;
            }
        }
        return toFind;
    }

    public Participant findParticipantByEmail(String email) {
        Participant toFind = null;
        for (Participant participant : participants) {
            if (participant.email.equals(email)) {
                toFind = participant;
                break;
            }
        }
        return toFind;
    }

    public void displayEvents() {
        for (Event event : events) {
            System.out.println("Event: " + event.name + ", Ort: " + event.location);
            for (Participant participant : event.participants) {
                System.out.println("Teilnehmer: " + participant.firstName + " " + participant.lastName + ", E-Mail: " + participant.email);
            }
        }
    }

    public void displayParticipants() {
        for (Participant participant : participants) {
            System.out.println("Teilnehmer: " + participant.firstName + " " + participant.lastName + ", E-Mail: " + participant.email);
        }
    }

}

