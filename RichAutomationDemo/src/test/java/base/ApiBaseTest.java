package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reporting.ExtentManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.*;

public class ApiBaseTest {
    protected ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;
    protected RequestSpecification requestSpec;
    protected Response response;

    @BeforeMethod
    public void setup() {
        String oauth2Token = loadToken();
        requestSpec =
                given()
                        .baseUri("https://gorest.co.in")
                        .auth()
                        .oauth2(oauth2Token);
    }

    @AfterMethod
    public void tearDown() {
        if (response != null) {
            test.info("Response:\n" + response.asPrettyString());
        }
        extent.flush();
    }

    private String loadToken() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("secrets.properties")) {
            props.load(input);
            return props.getProperty("oauth2.token");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load OAuth2 token", e);
        }
    }
}


