package lesson07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by eriol4ik on 21/01/2017.
 */
public class Test {
    private static String url = "jdbc:mysql://localhost:3306/first_db";
    private static String login = "root";
    private static String password = "qwerty";

    private static Connection connection;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        System.out.println("Driver loaded");

        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        } finally {
            if (connection != null) {
                try {
                    System.out.println("Connection success");
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
