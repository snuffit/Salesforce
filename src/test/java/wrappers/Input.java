package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {

    WebDriver driver;
    String label;
    WebElement element;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.element = driver.findElement(By.xpath(
                String.format("//label[text()='%s']/ancestor::lightning-input//input", label)));
    }

    public void write(String text) {
        element.sendKeys(text);
    }

    public WebElement get() {
        return element;
    }
}
