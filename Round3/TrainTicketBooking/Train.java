package TrainTicketBooking;

import java.util.Scanner;

public class Train {
    private final RacList rac;
    private final BookTicket book;
    private final CancelTicket cancel;
    private final WaitingList waiting;

    public Train() {
        this.rac = new RacList();
        this.book = new BookTicket();
        this.waiting = new WaitingList();
        this.cancel = new CancelTicket();
    }

    public void run() {
        this.start(new Scanner(System.in));
    }

    private void start(final Scanner sc) {
        this.showOptions();
        final int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                this.book.bookTicket(sc, rac, waiting);
            }
            case 2 -> {
                cancel.run(sc, book, rac, waiting);
            }
            case 3 -> {
                this.book.showPassangers();
            }
            case 4 -> {
                this.rac.showPassangersList();
            }
            case 5 -> {
                this.waiting.showPassangersList();
            }
            case 6 -> {
                System.out.println("\nSee ya");
                return;
            }
            default -> {
                System.out.println("Invalid Choice!");
                start(sc);
            }
        }
        start(sc);
    }


    private void showOptions() {
        System.out.println("Choose option");
        System.out.println("1. Book ticket ");
        System.out.println("2. Cancel ticket ");
        System.out.println("3. Show booked tickets ");
        System.out.println("4. Show RAC List ");
        System.out.println("5. Show waiting List ");
        System.out.println("6. Exit ");
        System.out.println();
    }
}
