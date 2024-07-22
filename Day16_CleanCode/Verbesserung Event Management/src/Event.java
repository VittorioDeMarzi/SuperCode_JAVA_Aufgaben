import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    String name;
    Date date;
    String location;
    int maxParticipants;
    List<Participant> participants = new ArrayList<>();

    public Event(String name, Date date, String location, int maxParticipants) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
    }
}
