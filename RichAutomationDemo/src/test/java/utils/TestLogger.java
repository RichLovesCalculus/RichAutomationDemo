package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    public static ExtentTest startTest(String title, ExtentReports extent, Logger logger) {
        logger.info(title);
        return extent.createTest(title);
    }
}
