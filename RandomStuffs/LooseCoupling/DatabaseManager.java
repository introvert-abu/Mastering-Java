package RandomStuffs.LooseCoupling;

public class DatabaseManager {
    private DataBaseProvider dataBaseProvider;

    public DatabaseManager(DataBaseProvider dataBaseProvider) {
        this.dataBaseProvider = dataBaseProvider;
    }

    public String getUserInfo() {
        return dataBaseProvider.getData();
    }
}
