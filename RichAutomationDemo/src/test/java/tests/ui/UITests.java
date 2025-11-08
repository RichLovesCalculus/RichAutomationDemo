package tests.ui;

import base.UIBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.UICredentials;

public class UITests extends UIBaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void basicLogIn() throws InterruptedException {
        loginPage.loginToProductsPage(UICredentials.getUsername(), UICredentials.getPassword());
        Thread.sleep(30000);
    }
}