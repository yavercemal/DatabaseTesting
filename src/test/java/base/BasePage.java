package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;

public class BasePage {

    public String userName = "cemal";
    public String surName = "yaver";

    public Connection connection;
    public static Statement statement;
    public static ResultSet rs;

    @BeforeTest
    public void setup() {
        String databaseURL = "jdbc:mysql://127.0.0.1:3306/example?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String user = "root";
        String password = "12345";
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(databaseURL, user, password);
            if (connection != null) {
                System.out.println("Connected the Database");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @AfterTest
    public void closed() throws InterruptedException {
        if (connection != null) {
            try {
                System.out.println("Closing Database Connection");
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
