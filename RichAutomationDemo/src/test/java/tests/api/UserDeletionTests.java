package tests.api;

import base.ApiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.ApiResponseHandler;
import utils.TestLogger;

public class UserDeletionTests extends ApiBaseTest {
    private static final Logger logger = LogManager.getLogger(UserDeletionTests.class);

    @Test
    public void testDeleteUserReturns204() {
        test = TestLogger.startTest("Deleting resource and verifying 204 response", extent, logger);
        response = requestSpec.delete("/public/v2/users/8222292");
        ApiResponseHandler.handleResponse(response, test, logger);
    }
}
