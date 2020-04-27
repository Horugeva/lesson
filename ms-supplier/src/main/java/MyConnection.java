import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection implements AutoCloseable {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String name = "postgres";
    String password = "qq14gm5j";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    public void close() {
    }
}
