package TrainTicketBooking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BookTicket {
    private static final int CAPACITY = 3;

    private int id;
    private int occupied;

    private Queue<Passanger> passangers;
    private Map<Integer, Passanger> passangerMap;

    public BookTicket() {
        this.id = 1;
        this.passangers = new LinkedList<>();
        this.passangerMap = new HashMap<>();
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Queue<Passanger> getPassangers() {
        return passangers;
    }

    public Map<Integer, Passanger> getPassangerMap() {
        return passangerMap;
    }

    public void bookTicket(Scanner sc, RacList rac, WaitingList waiting) {
        if (waiting.isFull()) {
            System.out.println("Sorry to say but we're out of tickets");
            System.out.println();
            return;
        }

        System.out.print("Enter Your Name : ");
        String name = sc.next();
        System.out.println();

        System.out.print("Enter Your Age : ");
        int age = sc.nextInt();
        System.out.println();

        System.out.print("Enter Your Prefference : ");
        String prefference = sc.next();
        System.out.println();

        if (!this.isFull()) {
            Passanger ticket = new Passanger(this.id, name, age, this.occupied + 1, prefference);
            this.id++;
            this.occupied++;
            this.book(ticket);
        } else {
            Passanger ticket = new Passanger(this.id, name, age, null, prefference);
            this.id++;
            this.checkRAC(ticket, rac, waiting);
        }
    }

    private void book(Passanger ticket) {
        this.passangers.offer(ticket);
        this.passangerMap.put(this.id, ticket);

        System.out.println("Booking Confirmed ");
        System.out.println("Your booking id is " + (this.id - 1) + " and your seat is " + this.occupied);
        System.out.println();
    }

    private void checkRAC(Passanger passanger, RacList rac, WaitingList waiting) {
        if (!rac.isFull()) {
            rac.add(passanger);
            rac.getPassangerMap().put(this.id - 1, passanger);

            System.out.println("Sorry no seats are available you are booked in RAC list");
            System.out.println("Your booking id is " + (this.id - 1));
            System.out.println();
        } else {

            this.checkWaitingList(passanger, waiting);
        }
    }

    private void checkWaitingList(Passanger ticket, WaitingList waiting) {
        waiting.add(ticket);
        waiting.getPassangerMap().put(this.id - 1, ticket);

        System.out.println("You are in waiting list");
        System.out.println("Your booking id is " + (this.id - 1));
        System.out.println();
    }

    public void showTickets() {
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

    private boolean isFull() {
        return this.occupied == BookTicket.CAPACITY;
    }
}
