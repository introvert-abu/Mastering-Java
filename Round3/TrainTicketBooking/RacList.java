package TrainTicketBooking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RacList implements ListStructure {
    private static final int CAPACITY = 1;

    private int occupied = 0;

    private final Queue<Passanger> orderOfPassangers = new LinkedList<>();
    private final Map<Integer, Passanger> passangers = new HashMap<>();

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Map<Integer, Passanger> getPassangers() {
        return passangers;
    }

    @Override
    public void add(Passanger passanger) {
        this.passangers.put(passanger.getId(), passanger);
        this.orderOfPassangers.offer(passanger);
        this.occupied++;
    }

    @Override
    public Passanger removeFirst() {
        Passanger removed = this.orderOfPassangers.poll();
        this.passangers.remove(removed.getId());
        this.occupied--;

        return removed;
    }

    @Override
    public Passanger remove(int ticketId) {
        Passanger removed = this.passangers.remove(ticketId);
        this.orderOfPassangers.remove(removed);
        this.occupied--;

        return removed;
    }

    @Override
    public boolean isFull() {
        return this.occupied == RacList.CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return this.occupied == 0;
    }

    @Override
    public void showPassangersList() {
        if (this.occupied == 0) {
            System.out.println("No passangers found");
            return;
        }

        for (Passanger passanger : passangers.values()) {
            System.out.println("----------------------");
            System.out.println("Passanger id : " + passanger.getId());
            System.out.println("Passanger name : " + passanger.getName());
            System.out.println("Passanger age : " + passanger.getAge());
            System.out.println("Passanger seatNo : " + passanger.getSeatNo());
            System.out.println("Passanger prefference : " + passanger.getPrefference());
            System.out.println("----------------------");
        }
        System.out.println();
    }
}
