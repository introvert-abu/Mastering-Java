package TrainTicketBooking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BookTicket{

    private static final int TOTAL_CAPACITY = 6;
    private static final int U_CAPACITY = 2;
    private static final int M_CAPACITY = 2;
    private static final int L_CAPACITY = 2;

    private int id = 1;
    private int seatNo = 1;
    private int occupiedU = 0;
    private int occupiedM = 0;
    private int occupiedL = 0;

    Map<Integer, Passanger> uPassangers = new HashMap<>();
    Map<Integer, Passanger> mPassangers = new HashMap<>();
    Map<Integer, Passanger> lPassangers = new HashMap<>();
    Queue<Integer> emptySeats = new LinkedList<>();

    public int getOccupiedU() {
        return occupiedU;
    }

    public void setOccupiedU(int occupiedU) {
        this.occupiedU = occupiedU;
    }

    public int getOccupiedM() {
        return occupiedM;
    }

    public void setOccupiedM(int occupiedM) {
        this.occupiedM = occupiedM;
    }

    public int getOccupiedL() {
        return occupiedL;
    }

    public void setOccupiedL(int occupiedL) {
        this.occupiedL = occupiedL;
    }

    public Map<Integer, Passanger> getuPassangers() {
        return uPassangers;
    }

    public Map<Integer, Passanger> getmPassangers() {
        return mPassangers;
    }

    public Map<Integer, Passanger> getlPassangers() {
        return lPassangers;
    }

    public Queue<Integer> getEmptySeats() {
        return emptySeats;
    }

    public void bookTicket(Scanner sc, RacList rac, WaitingList waiting) {
        if (waiting.isFull()) {
            System.out.println("Sorry we are out of tickets!");
            return;
        }

        System.out.println("Enter your name : ");
        String name = sc.next();
        System.out.println();

        System.out.println("Enter your age : ");
        int age = sc.nextInt();
        System.out.println();

        char prefference = this.askPrefference(sc);

        Passanger passanger = new Passanger(this.id, name, age, null, prefference);

        if (this.seatNo <= BookTicket.TOTAL_CAPACITY + 1) {
            passanger.setSeatNo(this.seatNo++);
        } else if (!emptySeats.isEmpty()) {
            passanger.setSeatNo(emptySeats.poll());
        }

        if (this.isFull()) {
            this.checkRac(rac, waiting, passanger);
        } else {
            switch (Character.toUpperCase(prefference)) {
                case 'U' -> {
                    System.out.println("Booking Success your ticketId is " + this.id);
                    this.uPassangers.put(this.id++, passanger);
                    this.occupiedU++;
                }
                case 'M' -> {
                    System.out.println("Booking Success your ticketId is " + this.id);
                    this.mPassangers.put(this.id++, passanger);
                    this.occupiedM++;
                }
                case 'L' -> {
                    System.out.println("Booking Success your ticketId is " + this.id);
                    this.lPassangers.put(this.id++, passanger);
                    this.occupiedL++;
                }
                default -> {
                    System.out.println("Booking cancelled");
                }
            }
        }
    }

    private void checkRac(RacList rac, WaitingList waiting, Passanger passanger) {
        this.id++;
        if (rac.isFull()) {
            System.out.println("You are in waiting list your id is " + (this.id - 1));
            waiting.add(passanger);
        } else {
            System.out.println("You are in Rac List your ticketId is " + (this.id - 1));
            rac.add(passanger);
        }
    }

    private char askPrefference(Scanner sc) {
        System.out.println("Enter your Prefference : ");
        char prefference = sc.next().charAt(0);
        System.out.println();

        if (this.isFull()) {
            return prefference;
        }

        switch (Character.toUpperCase(prefference)) {
            case 'U' -> {
                if (this.checkAvailablity(this.uPassangers, BookTicket.U_CAPACITY)) {
                    return 'U';
                } else {
                    return this.showAvailablity(sc);
                }
            }
            case 'M' -> {
                if (this.checkAvailablity(this.mPassangers, BookTicket.M_CAPACITY)) {
                    return 'M';
                } else {
                    return this.showAvailablity(sc);
                }
            }
            case 'L' -> {
                if (this.checkAvailablity(this.lPassangers, BookTicket.L_CAPACITY)) {
                    return 'L';
                } else {
                    return this.showAvailablity(sc);
                }
            }
            case 'C' -> {
                return 'C';
            }
            default -> {
                System.out.println("Invalid Prefference!!");
                return askPrefference(sc);
            }
        }
    }

    private boolean checkAvailablity(Map<Integer, Passanger> passangers, int totalPassangers) {
        return passangers.size() < totalPassangers;
    }

    private boolean isFull() {
        return this.occupiedL + this.occupiedM + this.occupiedU == BookTicket.TOTAL_CAPACITY;
    }

    private boolean isEmpty() {
        return this.occupiedL + this.occupiedM + this.occupiedU == 0;
    }

    private char showAvailablity(Scanner sc) {
        System.out.println("------- Available seats --------");
        System.out.println("U seats : " + (BookTicket.U_CAPACITY - this.occupiedU));
        System.out.println("M seats : " + (BookTicket.M_CAPACITY - this.occupiedM));
        System.out.println("L seats : " + (BookTicket.L_CAPACITY - this.occupiedL));
        System.out.println("Press C to cancel!!!");
        System.out.println("Wanna switch ?");
        return this.askPrefference(sc);
    }

    public void showPassangers() {
        if (this.isEmpty()) {
            System.out.println("No passangers found");
            return;
        }

        this.showPassangersList(uPassangers);
        this.showPassangersList(mPassangers);
        this.showPassangersList(lPassangers);
    }

    private void showPassangersList(Map<Integer, Passanger> passangers) {
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
