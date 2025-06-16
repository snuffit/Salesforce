package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPageFactory extends BasePage {

    private final String URI = BASE_URL + "my.salesforce.com/";

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement loginButton;

    @Override
    public LoginPageFactory open() {
        log.info("Open LoginPage URI: '{}'", URI);
        driver.get(URI);
        return this;
    }

    @Override
    public LoginPageFactory isPageOpend() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail();
        }
        log.info("Page is loaded");
        return this;
    }

    public HomePage login(String user, String password) {
        log.info("Login");
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
