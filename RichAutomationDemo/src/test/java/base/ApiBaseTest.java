package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reporting.ExtentManager;

import static io.restassured.RestAssured.*;

public class ApiBaseTest {
    protected ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;
    protected RequestSpecification requestSpec;
    protected Response response;

    @BeforeMethod
    public void setup() {
        requestSpec =
                given()
                        .baseUri("https://gorest.co.in")
                        .auth()
                        .oauth2("eab16e9a233c66e1d685f726687ebcc76146dd324a0621b6e9a9a5741d9613a0");
    }

    @AfterMethod
    public void tearDown() {
        if (response != null) {
            test.info("Response:\n" + response.asPrettyString());
        }
        extent.flush();
    }
}


