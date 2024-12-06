package TrainTicketBooking;

public interface ListStructure {

    void add(Passanger passanger);

    Passanger remove(int ticketId);

    Passanger removeFirst();

    boolean isEmpty();

    boolean isFull();

    void showPassangersList();
}
