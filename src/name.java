import java.sql.*;
import java.util.ArrayList;

public class name {
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
    public ArrayList<Name> showData() {
        ArrayList<Name>username=new ArrayList<>();
        try {

            Connection connection = connect();
            String sql = "SELECT id, username\n" +
                    "\tFROM tname;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Name person= new Name(resultSet.getInt("id"),resultSet.getString("username"));
                username.add(person);
                System.out.println();
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException:" + e);
        }
        return username;
    }
    public ArrayList<Name> Updeta(int id,String name){
        ArrayList<Name>Updet=showData();
        for (Name i:Updet) {
            if(i.getID()==id){
                emou Cosemou=new emou();
                Cosemou.Update(id,name);
                i.setName(name);
            }
        }
        return Updet;
    }
    public ArrayList<Name> Insert(int id,String name){
        ArrayList<Name>Insert=showData();
        for (Name i:Insert) {
            if(i.getID()==id){
                emou Cosemou=new emou();
                Cosemou.Insert(id,name);
                i.setName(name);
            }
        }
        return Insert;
    }

    class Name{
    private int id;
    private String name;

    public Name(int id, String username) {
        this.id=id;
        name=username;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

}
