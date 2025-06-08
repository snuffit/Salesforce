package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        driver.get(URI);
        return this;
    }

    @Override
    public LoginPageFactory isPageOpend() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public HomePage login(String user, String password) {
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
