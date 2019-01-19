package ro.paneabogdan.homework;

import java.util.logging.Logger;

public class FestivalStatisticsThread implements Runnable {

    private FestivalGate gate;
    private boolean counterAttendeeMax = true;

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void run() {
        while (counterAttendeeMax) {
            if (gate.getFestivalAttendeeThreads().size() > 0) {
                if (gate.getFestivalAttendeeThreads().size() == 100) {
                    counterAttendeeMax = false;
                }
                Integer[] ticketType = {0, 0, 0, 0, 0};
                for (FestivalAttendeeThread attendeeThread : gate.getFestivalAttendeeThreads()) {
                    switch (attendeeThread.getTicketType()) {
                        case FULL:
                            ticketType[0] += 1;
                            break;
                        case FULLVIP:
                            ticketType[1] += 1;
                            break;
                        case FREEPASS:
                            ticketType[2] += 1;
                            break;
                        case ONEDAY:
                            ticketType[3] += 1;
                            break;
                        default:
                            ticketType[4] += 1;
                    }
                }
                String allPeople = "";
                if (!counterAttendeeMax) {
                    allPeople = "All ";
                }

                LOGGER.info("------------- " + allPeople + gate.getFestivalAttendeeThreads().size() + " " + "people entered." + " -------------");
                LOGGER.info(ticketType[0] + " " + "people have " + TicketType.FULL.getTicketType());
                LOGGER.info(ticketType[1] + " " + "people have " + TicketType.FULLVIP.getTicketType());
                LOGGER.info(ticketType[2] + " " + "people have " + TicketType.FREEPASS.getTicketType());
                LOGGER.info(ticketType[3] + " " + "people have " + TicketType.ONEDAY.getTicketType());
                LOGGER.info(ticketType[4] + " " + "people have " + TicketType.ONEDAYVIP.getTicketType());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
