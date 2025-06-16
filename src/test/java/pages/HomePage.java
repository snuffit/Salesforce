package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class HomePage extends BasePage{

    private final String URI = BASE_URL + "lightning.force.com/lightning/setup/SetupOneHome/home";
    private final By TITLE = By.xpath("//*[@id='setupComponent']//span[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        log.info("Open HomePage URI: '{}'", URI);
        driver.get(URI);
        return this;
    }

    @Override
    public HomePage isPageOpend() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(TITLE)));
        }catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail();
        }
        log.info("Page is loaded");
        return this;
    }
}
