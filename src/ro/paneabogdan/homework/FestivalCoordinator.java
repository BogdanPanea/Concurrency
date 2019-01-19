package ro.paneabogdan.homework;

import java.util.Random;

public class FestivalCoordinator implements Runnable {

    private String festivalGateName;
    private FestivalGate festivalGate;
    private int counter = 0;

    FestivalCoordinator(String festivalGate) {
        this.festivalGateName = festivalGate;
        this.festivalGate = new FestivalGate(festivalGateName);
    }

    public TicketType generateTicketType() {
        Random randomno = new Random();
        return TicketType.values()[randomno.nextInt(TicketType.values().length)];
    }

    public void run() {
        while (counter < 100) {
            TicketType ticketType = generateTicketType();
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(ticketType, festivalGate);
            Thread t1 = new Thread(festivalAttendeeThread);
            t1.start();

            counter += 1;

            try {
                Thread.sleep((long)(Math.random() * 1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startFestivalStatisticsThread() {
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);
        Thread t1 = new Thread(festivalStatisticsThread);
        t1.start();
    }
}
