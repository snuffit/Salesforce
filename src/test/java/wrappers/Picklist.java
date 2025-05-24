package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Picklist {

    WebDriver driver;
    String label;
    String selectPattern = "//label[text()='%s']/ancestor::lightning-picklist//";
    WebElement element;
    Actions actions;

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.element = driver.findElement(By.xpath(String.format(selectPattern + "button", label)));

        this.actions = new Actions(driver);
    }

    public void select(String option) {
        element.click();
        actions.moveToElement(driver.findElement(By.xpath(String.format(
                        selectPattern + "lightning-base-combobox-item//span[text()='%s']", label, option))))
                .click().build().perform();
    }

    public WebElement get() {
        return element;
    }
}
