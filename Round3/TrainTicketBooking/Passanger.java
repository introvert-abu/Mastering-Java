package TrainTicketBooking;

public class Passanger {
    private int id;
    private int age;
    private String name;
    private Integer seatNo;
    private char prefference;

    public Passanger(int id, String name, int age, Integer seatNo, char prefference) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.seatNo = seatNo;
        this.prefference = prefference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public char getPrefference() {
        return prefference;
    }

    public void setPrefference(char ticketStatus) {
        this.prefference = ticketStatus;
    }
}
