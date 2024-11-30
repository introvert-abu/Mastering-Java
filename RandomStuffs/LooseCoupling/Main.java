package RandomStuffs.LooseCoupling;

public class Main {
    public static void main(String[] args) {
        Database1 db1 = new Database1();
        DatabaseManager db = new DatabaseManager(db1);
        System.out.println(db.getUserInfo());
        Database2 db2 = new Database2();
        db = new DatabaseManager(db2);
        System.out.println(db.getUserInfo());
    }
}
