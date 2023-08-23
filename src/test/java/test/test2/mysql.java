package test.test2;
import java.sql.*;
public class mysql {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/member?user=root";
        String userName = "root";
        String password = "alswls1101.";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from member");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
