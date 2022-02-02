
public class Main {

    public static void main(String[] args) {

        UserTableManager userTableManager = new UserTableManager();
        // AbstractTableManager<UserData> abstractTableManager =
            // new AbstractTableManager();

        UserData userData = new UserData("Elizabeth Taylor",
                "betty.taylor@hotwire.com");
        userTableManager.putItem(userData);

    }
}
