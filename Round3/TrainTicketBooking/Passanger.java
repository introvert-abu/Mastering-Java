package TrainTicketBooking;

public class Passanger {
    private int id;
    private String name;
    private int age;
    private Integer seatNo;
    private String prefference;

    public Passanger(int id, String name, int age, Integer seatNO, String prefference) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.seatNo = seatNO;
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

    public void setSeatNo(Integer seatNO) {
        this.seatNo = seatNO;
    }

    public String getPrefference() {
        return prefference;
    }

    public void setPrefference(String ticketStatus) {
        this.prefference = ticketStatus;
    }
}
