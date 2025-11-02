package tests.api;

import base.ApiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.ApiResponseHandler;
import utils.TestLogger;

public class UserRetrievalTests extends ApiBaseTest {
    private static final Logger logger = LogManager.getLogger(UserRetrievalTests.class);

    @Test
    public void testGetUserReturns200() {
        test = TestLogger.startTest("Sending GET request and verifying 200 response", extent, logger);
        response = requestSpec.get("/public/v2/users/8222292");
        ApiResponseHandler.handleResponse(response, test, logger);
    }
}
