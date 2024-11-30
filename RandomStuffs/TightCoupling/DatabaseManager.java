package RandomStuffs.TightCoupling;

public class DatabaseManager {
    private Database1 database = new Database1();

    public String getUserInfo() {
        return database.getData();
    }
}
