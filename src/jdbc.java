import java.sql.*;

public class jdbc {
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
            String sql = "SELECT id=?d, name\n" +
                    "\tFROM public.name;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID:" + resultSet.getString("id"));
                System.out.println("Nane:" + resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException:" + e);
        }
    }

    public void Insert(int id, String name) {
        Connection connection = connect();
        String sql = String.format("INSERT INTO public.name(\n" +
                "\tid, name)\n" +
                "\tVALUES ('%s','%s');", id, name);
        try {
            Statement st = connection.createStatement();
            st.execute(sql);
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void Update(int id, String name) {
        Connection connection = connect();
        String sql = String.format("UPDATE public.name\n" +
                "\tSET name☺=%s\n" +
                "\tWHERE ID=id;",name);
        try {
            Statement st = connection.createStatement();
            st.execute(sql);
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
