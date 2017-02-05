package lesson07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by eriol4ik on 21/01/2017.
 */
public class InsertJDBCExample {
    private static String url = "jdbc:mysql://localhost:3306/first_db";
    private static String login = "root";
    private static String password = "qwerty";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        System.out.println("Driver loaded");

        try {
            User user1 = new User(4, "test1", "test");
            User user2 = new User(5, "test2", "test");
            User user3 = new User(6, "test3", "test");
            List<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            users.add(user3);

            Connection connection = DriverManager.getConnection(url, login, password);
            String query = "INSERT INTO 'users' ('id', 'login', 'password') " +
                           "VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            for (User user : users) {
                statement.setInt(1, user.getId());
                statement.setString(2, user.getLogin());
                statement.setString(3, user.getPassword());
                System.out.println(statement.toString());
                statement.execute();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }

    }
}
