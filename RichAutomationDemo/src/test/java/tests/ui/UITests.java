package tests.ui;

import base.UIBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UITests extends UIBaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void basicLogIn() throws InterruptedException {
        loginPage.loginToProductsPage("test@qabrains.com", "Password123");
        Thread.sleep(1000);
    }
}