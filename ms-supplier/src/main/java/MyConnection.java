import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "qq14gm5j";


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        return connection;
    }
}