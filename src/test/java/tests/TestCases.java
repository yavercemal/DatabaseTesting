package tests;

import base.BasePage;
import org.testng.annotations.Test;

import java.sql.*;

public class TestCases extends BasePage {

        @Test
        public void testDb() {
        try {
            String query = "select * from persons";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()) {
                int Id= rs.getInt("id");
                String UserName= rs.getString("name");
                String SurName=rs.getString("surname");
                System.out.println(Id + " " + UserName + " " + SurName + " ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
