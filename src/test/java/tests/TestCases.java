package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class TestCases extends BasePage {

        String userName = "cemal";
        String surName = "yaver";

        @Test
        public void testDb() {
        try {
            String query = "select * from persons";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()) {
                int Id= rs.getInt("id");
                String getUserName = rs.getString("name");
                String getSurName = rs.getString("surname");
                Assert.assertEquals(getUserName, userName, "userName incorrect");
                Assert.assertEquals(getSurName, surName, "surName incorrect");
                System.out.println(Id + " " + userName + " " + surName + " ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
