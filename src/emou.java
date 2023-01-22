import java.sql.*;

/**
 * credit to ariel for class name
 */
public class emou {
        public Connection connect() {
            String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
            String userName = "postgres";
            String password = "sharel120804";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
                System.out.printf("There is connection");
                return connection;
            } catch (SQLException e) {
                System.out.printf("Error!!");
                throw new RuntimeException(e);
            }
        }

        public void showData() {
            try {
                Connection connection = connect();
                String sql = "SELECT id, username\n" +
                        "\tFROM tname;";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println("ID:" + resultSet.getString("id"));
                    System.out.println("Nane:" + resultSet.getString("username"));
                }
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("SQLException:" + e);
            }
        }

        public void Insert(int id, String name1) {
            Connection connection = connect();
            String sql = "INSERT INTO tname(\n" +
                    "\t username)\n" +
                    "\tVALUES (?)";
            try {
                Statement st = connection.createStatement();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,name1);
                statement.executeUpdate();
                st.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }


        }

        public void Update(int idold, String name) {
            Connection connection = connect();
            String sql = ("UPDATE tname\n" +
                    "\tSET username=?\n" +
                    "\tWHERE id=?");
            try {
                Statement st = connection.createStatement();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, idold);
                statement.executeUpdate();
                st.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

}