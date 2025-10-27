package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    //Web elements
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;


    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Action methods
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButtonViaJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);
    }

    public void clickSubmitButtonViaActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }

    public void loginToProductsPageViaActions(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmitButtonViaActions();
    }

    public void loginToProductsPageViaJS(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmitButtonViaJS();
    }
}
