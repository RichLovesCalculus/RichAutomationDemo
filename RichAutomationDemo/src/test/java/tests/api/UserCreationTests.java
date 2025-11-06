package tests.api;

import base.ApiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.APIClient;
import utils.ApiResponseHandler;
import utils.TestLogger;
import utils.PayloadFactory;
import java.util.Map;

public class UserCreationTests extends ApiBaseTest {
    private static final Logger logger = LogManager.getLogger(UserCreationTests.class);
    private static final String dataSource = "src/test/resources/test_data.xlsx";

    @Test
    public void testPostUserReturns201() throws Exception {
        test = TestLogger.startTest("Sending POST request and verifying 201 response", extent, logger);
        Map<String, String> payload = PayloadFactory.getPayload(dataSource, 0, 1);
        logger.info("POST request payload: {}", payload);
        response = APIClient.createUser(payload);
        ApiResponseHandler.handleResponse(response, test, logger);
    }
}
