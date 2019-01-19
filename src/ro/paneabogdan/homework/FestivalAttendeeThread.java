package ro.paneabogdan.homework;

public class FestivalAttendeeThread implements Runnable {

    private TicketType ticketType;
    private FestivalGate festivalGate;

    FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.festivalGate = gate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public FestivalGate getFestivalGate() {
        return festivalGate;
    }

    public void run() {
        festivalGate.addAttendee(this);
    }
}
