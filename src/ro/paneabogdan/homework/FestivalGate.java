package ro.paneabogdan.homework;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {

    private Queue<FestivalAttendeeThread> festivalAttendeeThreads = new LinkedList<>();
    private String gateName;

    FestivalGate(String gateName) {
        this.gateName = gateName;
    }

    Queue<FestivalAttendeeThread> getFestivalAttendeeThreads() {
        return festivalAttendeeThreads;
    }

    public String getGateName() {
        return gateName;
    }


    void addAttendee(FestivalAttendeeThread attendee) {
        festivalAttendeeThreads.add(attendee);
    }
}