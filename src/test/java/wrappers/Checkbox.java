package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    WebDriver driver;
    String label;
    WebElement element;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.element = driver.findElement(By.xpath(
                String.format("//*[text()='%s']/ancestor::lightning-input//input", label)));
    }

    public void select(boolean isSelect) {
        if (isSelect) {
            element.click();
        }
    }

    public WebElement get() {
        return element;
    }
}
