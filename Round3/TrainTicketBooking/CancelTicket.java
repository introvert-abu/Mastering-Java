package TrainTicketBooking;

import java.util.Scanner;

public class CancelTicket {

    public void run(Scanner sc, BookTicket book, RacList rac, WaitingList waiting) {
        this.showOptions();
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                this.cancelBooked(sc, book, rac, waiting);
            }
            case 2 -> {
                this.cancelRacList(sc, rac, waiting);
            }
            case 3 -> {
                this.cancelWaitingList(sc, waiting);
            }
            default -> {
                System.out.println("Invalid choice!");
                run(sc, book, rac, waiting);
            }
        }
    }

    private void cancelWaitingList(Scanner sc, WaitingList waiting) {
        System.out.println("Enter ticket id below ");
        int ticketId = sc.nextInt();

        if (waiting.getPassangers().containsKey(ticketId)) {
            waiting.remove(ticketId);
            System.out.println("Ticket Cancelled");
            System.out.println();

        } else {
            System.out.println("Invalid TicketId ");
            System.out.println();
        }
    }

    private void cancelRacList(Scanner sc, RacList rac, WaitingList waiting) {
        System.out.println("Enter ticket id below ");
        int ticketId = sc.nextInt();

        if (rac.getPassangers().containsKey(ticketId)) {
            rac.remove(ticketId);

            if (!waiting.isEmpty()) {
                Passanger waitingPassanger = waiting.removeFirst();
                rac.add(waitingPassanger);
            }

            System.out.println("Ticket Cancelled");
            System.out.println();
        } else {

            System.out.println("Invalid TicketId ");
            System.out.println();
        }
    }

    private void cancelBooked(Scanner sc, BookTicket book, RacList rac, WaitingList waiting) {
        System.out.println("Enter ticket id below ");
        int ticketId = sc.nextInt();

        if (book.getuPassangers().containsKey(ticketId)) {
            Passanger removedPassanger = book.getuPassangers().remove(ticketId);

            if (!rac.isEmpty()) {
                Passanger racPassanger = rac.removeFirst();
                racPassanger.setSeatNo(removedPassanger.getSeatNo());
                racPassanger.setPrefference(removedPassanger.getPrefference());
                book.getuPassangers().put(racPassanger.getId(), racPassanger);

                if (!waiting.isEmpty()) {
                    Passanger waitingPassanger = waiting.removeFirst();
                    rac.add(waitingPassanger);
                }
            } 
            
            else {
                book.setOccupiedU(book.getOccupiedU()-1);
                book.getEmptySeats().add(removedPassanger.getSeatNo());
            }

            System.out.println("Ticket Cancelled");
            System.out.println();
        }

        else if (book.getmPassangers().containsKey(ticketId)) {
            Passanger removedPassanger = book.getmPassangers().remove(ticketId);

            if (!rac.isEmpty()) {
                Passanger racPassanger = rac.removeFirst();
                racPassanger.setSeatNo(removedPassanger.getSeatNo());
                racPassanger.setPrefference(removedPassanger.getPrefference());
                book.getmPassangers().put(racPassanger.getId(), racPassanger);

                if (!waiting.isEmpty()) {
                    Passanger waitingPassanger = waiting.removeFirst();
                    rac.add(waitingPassanger);
                }
            } 
            
            else {
                book.setOccupiedM(book.getOccupiedM()-1);
                book.getEmptySeats().add(removedPassanger.getSeatNo());
            }

            System.out.println("Ticket Cancelled");
            System.out.println();
        }

        else if (book.getlPassangers().containsKey(ticketId)) {
            Passanger removedPassanger = book.getlPassangers().remove(ticketId);

            if (!rac.isEmpty()) {
                Passanger racPassanger = rac.removeFirst();
                racPassanger.setSeatNo(removedPassanger.getSeatNo());
                racPassanger.setPrefference(removedPassanger.getPrefference());
                book.getlPassangers().put(racPassanger.getId(), racPassanger);

                if (!waiting.isEmpty()) {
                    Passanger waitingPassanger = waiting.removeFirst();
                    rac.add(waitingPassanger);
                }
            } 
            
            else {
                book.setOccupiedL(book.getOccupiedL()-1);
                book.getEmptySeats().add(removedPassanger.getSeatNo());
            }

            System.out.println("Ticket Cancelled");
            System.out.println();
        }

        else {
            System.out.println("Invalid TicketId!");
            System.out.println();
        }
    }

    private void showOptions() {
        System.out.println("Choose any one");
        System.out.println("1.Cancel booked ticket ");
        System.out.println("2.Cancel rac ticket ");
        System.out.println("3.Cancel from waitign list ");
        System.out.println();
    }

}
