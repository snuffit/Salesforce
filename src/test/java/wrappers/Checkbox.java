package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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
        log.info("Select checkbox:{}", label);
        if (isSelect) {
            element.click();
        }
    }

    public WebElement get() {
        log.info("Get element checkbox:{}", label);
        return element;
    }
}
