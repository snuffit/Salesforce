package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final String BASE_PATH = "//input[@id='%s']";
    private final By
            USERNAME = By.xpath(String.format(BASE_PATH, "username")),
            PASSWORD = By.xpath(String.format(BASE_PATH, "password")),
            LOGIN = By.xpath(String.format(BASE_PATH, "Login"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        open();
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN).click();
    }
}
