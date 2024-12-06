package TaxiBooking;

public class Customer {

    private int bookingId;
    private int customerId;
    private Character pickupPoint;
    private Character dropPoint;
    private int pickupTime;
    private int dropTime;
    private int charged;

    public Customer(int bookingId, int customerId, Character pickupPoint, Character dropPoint, int pickupTime,
            int dropTime, int charged) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.charged = charged;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Character getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Character pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Character getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(Character dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getCharged() {
        return charged;
    }

    public void setCharged(int charged) {
        this.charged = charged;
    }

    @Override
    public String toString() {
        return bookingId + " " + customerId + " " + pickupPoint
                + " " + dropPoint + " " + pickupTime + " " + dropTime + " "
                + charged;
    }
}
