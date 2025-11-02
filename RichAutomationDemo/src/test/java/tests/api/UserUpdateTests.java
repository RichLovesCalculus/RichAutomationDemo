package tests.api;

import base.ApiBaseTest;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.ApiResponseHandler;
import utils.PayloadFactory;
import utils.TestLogger;

import java.util.Map;

public class UserUpdateTests extends ApiBaseTest {
    private static final Logger logger = LogManager.getLogger(UserUpdateTests.class);
    private static final String dataSource = "src/test/resources/test_data_for_POST.xlsx";

    @Test
    public void testPutUserReturns200() throws Exception{
        test = TestLogger.startTest("Updating resource and verifying 200 response", extent, logger);
        Map<String, String> payload = PayloadFactory.getPayload(dataSource, 0, 6);
        logger.info("PUT request payload: {}", payload);
        response = requestSpec
                .contentType(ContentType.JSON)
                .body(payload)
                .put("/public/v2/users/8222292");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testPatchUserReturns200() {
        test = TestLogger.startTest("Partially updating resource and verifying 200 response", extent, logger);
        logger.info("PATCH request payload: {}", "");
        response = requestSpec
                .contentType(ContentType.JSON)
                .body("")
                .put("/public/v2/users/8222292");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

}
