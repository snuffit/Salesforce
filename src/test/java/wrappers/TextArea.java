package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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
        log.info("Write '{}' in '{}'", text, label);
        element.sendKeys(text);
    }

    public WebElement get() {
        log.info("Get textarea '{}'", label);
        return element;
    }
}
