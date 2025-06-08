package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        driver.get(URI);
        return this;
    }

    @Override
    public LoginPage isPageOpend() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN)));
        return this;
    }

    public HomePage login(String user, String password) {
        open();
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN).click();
        return new HomePage(driver);
    }
}
