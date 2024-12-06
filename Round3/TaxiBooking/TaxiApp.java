package TaxiBooking;

import java.util.Scanner;

public class TaxiApp {

    private final BookingController book = new BookingController();

    public void run() {
        Scanner sc = new Scanner(System.in);
        this.start(sc);
        sc.close();
    }

    private void start(Scanner sc) {
        this.showOptions();
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                book.start(sc);
            }
            case 2 -> {
                book.showDetails();
            }
            case 3 -> {
                System.out.println("Nice meeting you");
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
        System.out.println("1.Book Taxi ");
        System.out.println("2.Show Taxi Details ");
        System.out.println("3.Exit  \n");
    }

}
