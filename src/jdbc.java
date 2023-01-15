import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    public static void connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "sharel120804";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.printf("There is connection");
            connection.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            throw new RuntimeException(e);
        }
    }
}
