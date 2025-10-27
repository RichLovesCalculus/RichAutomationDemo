package tests;

import java.sql.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ExtentManager;

public class DatabaseTests {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Test
    public void basicQueryExamples() throws InterruptedException {
        test = extent.createTest("Basic querying examples");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:;"
                        + "INIT=RUNSCRIPT FROM 'classpath:scripts/users.sql';")) {

            //Return all records from customer_orders
            System.out.println("Connected = " + connection.isValid(0));
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT c.first_name, c.last_name, c.email, o.order_date\n" +
                    "FROM customers c\n" +
                    "JOIN customer_orders o ON c.customer_id = o.customer_id;");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                //String productName = resultSet.getString("product_name");
                Date orderDate = resultSet.getDate("order_date");
                //BigDecimal totalSpent = resultSet.getBigDecimal("total_spent");


                System.out.println(String.format(
                        "c.customer_id: %s | order_count: %s | email: %s | order_date: %s",
                        firstName, lastName, email, orderDate
                ));
            }
            test.pass("Data returned successfully.");

        } catch (SQLException e) {
            System.out.println("Problem: " + e.getMessage());
            test.fail("Error in query.");
        }
    }

    @AfterMethod
    public void teardown() {
        extent.flush();
    }
}