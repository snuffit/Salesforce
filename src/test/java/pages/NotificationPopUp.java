package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Log4j2
public class NotificationPopUp {

    private final By NOTIFICATION = By.cssSelector(".toastMessage");
    WebDriver driver;
    WebDriverWait wait;

    public NotificationPopUp(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail();
        }
        log.info("Get notification text");
        return driver.findElement(NOTIFICATION).getText();
    }
}
