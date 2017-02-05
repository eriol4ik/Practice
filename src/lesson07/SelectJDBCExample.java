package lesson07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eriol4ik on 22/01/2017.
 */
public class SelectJDBCExample {
    private static String url = "jdbc:mysql://localhost:3306/first_db";
    private static String login = "root";
    private static String password = "qwerty";

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, login, password);
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS");
            Statement statement1 = connection.createStatement();

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM USERS");
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
