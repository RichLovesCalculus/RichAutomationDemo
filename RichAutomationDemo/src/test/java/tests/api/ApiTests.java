package tests.api;

import base.ApiBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ApiResponseHandler;
import utils.TestLogger;
import utils.TestPayloadFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTests extends ApiBaseTest {

    private static final Logger logger = LogManager.getLogger(ApiTests.class);
    private static HashMap<String, Object> payLoad;

    @Test
    public void testPostUserReturns201() throws Exception {
        test = TestLogger.startTest("Sending POST request and verifying 201 response", extent, logger);
        List<Map<String, String>> spread = TestPayloadFactory.getPayloadsFromExcel("src/test/resources/test_data_for_POST.xlsx");
        Map<String, Object> payLoad = TestPayloadFactory.buildPayload(spread.get(2));
        logger.info("POST request payload: {}", payLoad);
        response = requestSpec
                .contentType(ContentType.JSON)
                .body(payLoad)
                .post("/public/v2/users");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testGetUserReturns200() {
        test = TestLogger.startTest("Sending GET request and verifying 200 response", extent, logger);
        response = requestSpec.get("/public/v2/users/8213095");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testPutUserReturns200() {
        test = TestLogger.startTest("Updating resource and verifying 200 response", extent, logger);
        //payLoad = PayloadFactory.createUserPayload();
        logger.info("PUT request payload: {}", payLoad);
        response = requestSpec
                    .contentType(ContentType.JSON)
                    .body(payLoad)
                    .put("/public/v2/users/8213095");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testPatchUserReturns200() {
        test = TestLogger.startTest("Partially updating resource and verifying 200 response", extent, logger);
        //payLoad = PayloadFactory.updateField("name", "Gee Roses");
        logger.info("PATCH request payload: {}", payLoad);
        response = requestSpec
                    .contentType(ContentType.JSON)
                    .body(payLoad)
                    .put("/public/v2/users/8213095");
        ApiResponseHandler.handleResponse(response, test, logger);
    }

    @Test
    public void testDeleteUserReturns204() {
        test = TestLogger.startTest("Deleting resource and verifying 204 response", extent, logger);
        response = requestSpec.delete("/public/v2/users/8213095");
        ApiResponseHandler.handleResponse(response, test, logger);
    }
}