package utils;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class ApiResponseHandler {

    public static void handleResponse(Response response, ExtentTest test, Logger logger) {
        int statusCode = response.getStatusCode();

        switch (statusCode) {
            case 200:
            case 201:
            case 204:
                String successMsg = "Success. Status code: " + statusCode;
                logger.info(successMsg);
                test.pass(successMsg);
                if (statusCode == 200 || statusCode == 201) {
                    test.info("Response body:\n" + response.asPrettyString());
                    logger.info("Response body:\n" + response.asPrettyString());
                }
                break;

            case 404:
            case 422:
                String errorMsg = response.jsonPath().getString("message");
                String failMsg = "Failure: " + errorMsg;
                logger.warn(failMsg);
                test.fail(failMsg);
                Assert.fail(failMsg);
                break;

            default:
                String unexpectedMsg = "Unexpected status code: " + statusCode;
                logger.error(unexpectedMsg);
                test.fail(unexpectedMsg);
                Assert.fail(unexpectedMsg);
        }
    }
}