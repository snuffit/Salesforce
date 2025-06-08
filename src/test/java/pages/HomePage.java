package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private final String URI = BASE_URL + "lightning.force.com/lightning/setup/SetupOneHome/home";
    private final By TITLE = By.xpath("//*[@id='setupComponent']//span[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        driver.get(URI);
        return this;
    }

    @Override
    public HomePage isPageOpend() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE)));
        return this;
    }
}
