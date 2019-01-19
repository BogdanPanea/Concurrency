package ro.paneabogdan.homework;

public enum TicketType {

    FULL("full tickets."), FULLVIP("full VIP passes."), FREEPASS("free passes."), ONEDAY("one-day passes."), ONEDAYVIP("one-day VIP passes.");

    private String ticketType;

    TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return ticketType;
    }
}