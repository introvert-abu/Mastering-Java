package TrainTicketBooking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RacList {
    private static final int CAPACITY = 1;
    private int occupied;

    private Queue<Passanger> passangers;
    private Map<Integer, Passanger> passangerMap;

    public RacList() {
        this.passangers = new LinkedList<>();
        this.passangerMap = new HashMap<>();
    }

    public Map<Integer, Passanger> getPassangerMap() {
        return passangerMap;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Queue<Passanger> getPassangers() {
        return passangers;
    }

    public int getOccupied() {
        return occupied;
    }

    public void add(Passanger ticket) {
        passangers.offer(ticket);
        this.occupied++;
    }

    public void showRacList() {
        if (occupied == 0) {
            System.out.println("\nNo passangers found!!\n");
            return;
        }
        for (Passanger passanger : passangers) {
            System.out.println("------------------------------------");
            System.out.println("Passanger ticket id : " + passanger.getId());
            System.out.println("Passanger name : " + passanger.getName());
            System.out.println("Passanger age : " + passanger.getAge());
            System.out.println("Passanger seat no : " + passanger.getSeatNo());
            System.out.println("Passanger Prefference : " + passanger.getPrefference());
            System.out.println("------------------------------------");
        }
        System.out.println();
    }

    public boolean isFull() {
        return this.occupied == RacList.CAPACITY;
    }

}
