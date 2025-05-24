package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {

    WebDriver driver;
    String label;
    WebElement element;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.element = driver.findElement(By.xpath(
                String.format("//label[text()='%s']/ancestor::lightning-textarea//textarea", label)));
    }

    public void write(String text) {
        element.sendKeys(text);
    }

    public WebElement get() {
        return element;
    }
}
