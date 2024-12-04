package TrainTicketBooking;

import java.util.Scanner;

public class CancelTicket {

    public void run(Scanner sc, BookTicket book, RacList rac, WaitingList waiting) {
        this.showOptions();
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                this.cancelBookedTicket(sc, book, rac, waiting);
            }
            case 2 -> {
                this.cancelRacTicket(sc, rac, waiting);
            }
            case 3 -> {
                this.cancelWaitingTicket(sc, waiting);
            }
            default -> {
                System.out.println("Invalid Choice");
                System.out.println();
                run(sc, book, rac, waiting);
            }
        }
    }

    private void cancelBookedTicket(Scanner sc, BookTicket book, RacList rac,
            WaitingList waiting) {

        System.out.print("Enter Ticket Id : ");
        int ticketId = sc.nextInt();
        System.out.println();

        if (book.getPassangerMap().containsKey(ticketId)) {
            Passanger passanger = book.getPassangerMap().get(ticketId);

            boolean hasNoRac = false;
            if (rac.getOccupied() != 0) {
                hasNoRac = true;
                Passanger racTicket = rac.getPassangers().poll();
                racTicket.setPrefference(passanger.getPrefference());
                racTicket.setSeatNo(passanger.getSeatNo());
                book.getPassangerMap().put(racTicket.getId(), racTicket);
                book.getPassangers().offer(racTicket);

                if (waiting.getOccupied() != 0) {
                    Passanger waitingPassanger = waiting.getPassangers().poll();
                    rac.getPassangers().offer(waitingPassanger);
                    rac.getPassangerMap().put(waitingPassanger.getId(), waitingPassanger);
                    waiting.setOccupied(waiting.getOccupied() - 1);
                } else {
                    rac.setOccupied(rac.getOccupied() - 1);
                }

            }

            book.getPassangers().remove(passanger);
            book.getPassangerMap().remove(ticketId);
            if (!hasNoRac) {
                book.setOccupied(book.getOccupied() - 1);
            }
            System.out.println("Ticket Canceled Successfully!!!");
            return;
        }

        System.out.println("Invalid Id");
        System.out.println();
    }

    private void cancelRacTicket(Scanner sc, RacList rac, WaitingList waiting) {
        System.out.print("Enter Ticket Id : ");
        int ticketId = sc.nextInt();
        System.out.println();

        if (rac.getPassangerMap().containsKey(ticketId)) {
            Passanger passanger = rac.getPassangerMap().get(ticketId);

            if (waiting.getOccupied() != 0) {
                Passanger waitingPassanger = waiting.getPassangers().poll();
                rac.getPassangers().offer(waitingPassanger);
                rac.getPassangerMap().put(waitingPassanger.getId(), waitingPassanger);
            }

            rac.getPassangers().remove(passanger);
            rac.getPassangerMap().remove(ticketId);
            rac.setOccupied(rac.getOccupied() - 1);

            System.out.println("Ticket Cancelled Successfully");
            System.out.println();
            return;
        }

        System.out.println("Invalid Id");
    }

    private void cancelWaitingTicket(Scanner sc, WaitingList waiting) {
        System.out.print("Enter Ticket Id : ");
        int ticketId = sc.nextInt();
        System.out.println();

        if (waiting.getPassangerMap().containsKey(ticketId)) {
            Passanger passanger = waiting.getPassangerMap().get(ticketId);

            waiting.getPassangers().remove(passanger);
            waiting.getPassangerMap().remove(ticketId);
            System.out.println("Ticket Cancelled Successfully");
            waiting.setOccupied(waiting.getOccupied() - 1);
            return;
        }

        System.out.println("Invalid Id");
        System.out.println();
    }

    private void showOptions() {
        System.out.println("Choose option");
        System.out.println("1.Cancel Booked Ticket");
        System.out.println("2.Cancel Rac Ticket");
        System.out.println("3.Cancel Waiting Ticket");
    }
}
