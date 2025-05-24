package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Notification {

    private final By NOTIFICATION = By.cssSelector(".toastMessage");
    WebDriver driver;
    WebDriverWait wait;

    public Notification(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION)).getText();
    }
}
