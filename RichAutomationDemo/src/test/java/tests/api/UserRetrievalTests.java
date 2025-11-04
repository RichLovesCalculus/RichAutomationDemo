package tests.api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import reporting.ExtentManager;
import utils.APIClient;
import utils.ApiResponseHandler;
import utils.TestLogger;

public class UserRetrievalTests {
    private final ExtentReports extent = ExtentManager.getInstance();
    private static final Logger logger = LogManager.getLogger(UserRetrievalTests.class);

    @Test
    public void testGetUserReturns200() {
        ExtentTest test = TestLogger.startTest("Sending GET request and verifying 200 response", extent, logger);
        Response response = APIClient.getUser(8222278);
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testGetUsersReturns200() {
        ExtentTest test = TestLogger.startTest("Sending GET request and verifying 200 response", extent, logger);
        Response response = APIClient.getUsers();
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
    }
}
