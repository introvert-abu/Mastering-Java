package TaxiBooking;

import java.util.Scanner;

public class BookingController {

    private static final int FIRST_KM_PRICE = 100;
    private static final int SUBSEQUENT_KM_PRICE = 10;
    private static final int MAXIMUM_TAXI_COUNT = 4;

    private Integer bookingId = 1;

    private Taxi[] taxis = new Taxi[BookingController.MAXIMUM_TAXI_COUNT];

    public BookingController() {
        for (int i = 0; i < taxis.length; i++) {
            taxis[i] = new Taxi();
        }
    }

    public void start(Scanner sc) {
        System.out.print("Enter uour id : ");
        int customerId = sc.nextInt();
        System.out.println();

        char customerPickupPoint = '-';
        while (true) {
            System.out.print("Enter pickup point : ");
            customerPickupPoint = sc.next().charAt(0);
            customerPickupPoint = Character.toUpperCase(customerPickupPoint);
            System.out.println();
            if (customerPickupPoint < 'A' || customerPickupPoint > 'F') {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        char customerDropPoint = 'A';
        while (true) {
            System.out.print("Enter drop point : ");
            customerDropPoint = sc.next().charAt(0);
            customerDropPoint = Character.toUpperCase(customerDropPoint);
            System.out.println();            
            if (customerDropPoint < 'A' || customerDropPoint > 'F') {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        int customerPickupTime = 0;
        while (true) {
            System.out.print("Enter pickup time : ");
            customerPickupTime = sc.nextInt();
            if (customerPickupTime < 0 || customerPickupTime > 23) {
                System.out.println("Invalid input");
                System.out.println();
                continue;
            }
            break;
        }

        int customerDropTime = this.calculateDropTime(customerPickupPoint, customerDropPoint) + customerPickupTime;
        int charedRupees = this.calculateCharge(customerPickupPoint, customerDropPoint);

        Customer customer = new Customer(this.bookingId, customerId, customerPickupPoint, customerDropPoint,
                customerPickupTime, customerDropTime, charedRupees);

        Taxi availableTaxi = this.checkAvailablity(customerPickupPoint, customerPickupTime);

        if (availableTaxi != null) {
            availableTaxi.setAllAttributes(customerPickupTime, customerDropTime, customerPickupPoint, customerDropPoint,
                    charedRupees);
            System.out.println(availableTaxi.getTaxiName() + " booked");
            availableTaxi.getCustomerDetails().add(customer);
        } else {
            System.out.println("Sorry No taxi is available right now \n");
        }
    }

    private Taxi checkAvailablity(char customerPickupPoint, int customerPickupTime) {
        Taxi availableTaxi = null;
        int lowTime = Integer.MAX_VALUE;

        for (int i = 0; i < this.taxis.length; i++) {
            int taxiEndTime = taxis[i].getCurruntEndTime();
            char taxiEndPoint = taxis[i].getCurruntEndPoint();

            int arrivalTime = taxiEndTime + Math.abs(taxiEndPoint - customerPickupPoint);
            if (arrivalTime < customerPickupTime && arrivalTime < lowTime) {
                availableTaxi = taxis[i];
                lowTime = arrivalTime;
            } else if (arrivalTime < customerPickupTime && arrivalTime == lowTime) {
                if (taxis[i].getTotalEarnings() < availableTaxi.getTotalEarnings()) {
                    availableTaxi = taxis[i];
                    lowTime = arrivalTime;
                }
            } else if (arrivalTime == customerPickupTime && arrivalTime < lowTime) {
                availableTaxi = taxis[i];
                lowTime = arrivalTime;
            } else if (arrivalTime == customerPickupTime && arrivalTime == lowTime) {
                if (taxis[i].getTotalEarnings() < availableTaxi.getTotalEarnings()) {
                    availableTaxi = taxis[i];
                    lowTime = arrivalTime;
                }
            }
        }

        return availableTaxi;
    }

    private int calculateCharge(char customerPicupPoint, char customerDropPoint) {
        int kilometers = (customerDropPoint - customerPicupPoint) * 3; // it should be * 15 for simplicity i took 3
        System.out.println(kilometers);
        int chargedPrice = (kilometers - 1) * BookingController.SUBSEQUENT_KM_PRICE + BookingController.FIRST_KM_PRICE;

        return chargedPrice;
    }

    private int calculateDropTime(char customerPicupPoint, char customerDropPoint) {
        return customerDropPoint - customerPicupPoint;
    }

    public void showDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("----------------------");
            taxi.showDetails();
            System.out.println("----------------------");
        }
    }

}
