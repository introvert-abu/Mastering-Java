package TaxiBooking;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private static int taxiCount = 0;

    private int totalEarnings;
    private String taxiName;
    private Character curruntStartPoint;
    private Character curruntEndPoint = 'A';
    private int curruntStartTime;
    private int curruntEndTime;

    private final List<Customer> customerDetails = new ArrayList<>();

    public Taxi() {
        this.taxiName = "Taxi - " + (++Taxi.taxiCount);
    }

    public Character getCurruntStartPoint() {
        return curruntStartPoint;
    }

    public void setCurruntStartPoint(Character curruntStartPoint) {
        this.curruntStartPoint = curruntStartPoint;
    }

    public Character getCurruntEndPoint() {
        return curruntEndPoint;
    }

    public void setCurruntEndPoint(Character curruntEndPoint) {
        this.curruntEndPoint = curruntEndPoint;
    }

    public int getCurruntStartTime() {
        return curruntStartTime;
    }

    public void setCurruntStartTime(int curruntStartTime) {
        this.curruntStartTime = curruntStartTime;
    }

    public int getCurruntEndTime() {
        return curruntEndTime;
    }

    public void setCurruntEndTime(int curruntEndTime) {
        this.curruntEndTime = curruntEndTime;
    }

    public String getTaxiName() {
        return taxiName;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public List<Customer> getCustomerDetails() {
        return customerDetails;
    }

    public void setAllAttributes(int taxiStartTime, int taxiEndTime, char taxiStartPoint, char taxiEndPoint, int totalEarnings) {
        this.curruntStartTime = taxiStartTime;
        this.curruntEndTime = taxiEndTime;
        this.curruntStartPoint = taxiStartPoint;
        this.curruntEndPoint = taxiEndPoint;    
        this.totalEarnings += totalEarnings;    
    }

    public void showDetails() {
        System.out.println(this.taxiName + " : Total earnings : " + this.totalEarnings);
        for (Customer customer : customerDetails) {
            System.out.println(customer);
        }
    }
}