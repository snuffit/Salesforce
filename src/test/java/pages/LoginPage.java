package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private final String BASE_PATH = "//input[@id='%s']",
            URI = BASE_URL + "my.salesforce.com/";
    private final By
            USERNAME = By.xpath(String.format(BASE_PATH, "username")),
            PASSWORD = By.xpath(String.format(BASE_PATH, "password")),
            LOGIN = By.xpath(String.format(BASE_PATH, "Login"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        log.info("Open LoginPage URI: '{}'", URI);
        driver.get(URI);
        return this;
    }

    @Override
    public LoginPage isPageOpend() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN)));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail();
        }
        log.info("Page is loaded");
        return this;
    }

    public HomePage login(String user, String password) {
        open();
        log.info("Login");
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN).click();
        return new HomePage(driver);
    }
}