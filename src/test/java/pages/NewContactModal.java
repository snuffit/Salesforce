package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.Picklist;

public class NewContactModal extends BasePage {

    private final String URI = "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new",
            TITLE_PATH = "//span[text()='%s']";
    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']"),
            DUPLICATE_ERROR = By.xpath("//*[text()='Similar Records Exist']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void open() {
        wait.until(driver -> {
            return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete");
        });
        driver.get(URI);
    }

    public void clickSaveButton() {
        duplicateErrorWait();
        driver.findElement(SAVE_BUTTON).click();
    }

    public void createContact(String phone, String homePhone, String salutation, String lastName, String department,
                              String assistant, String leadSource, String languages, String level) {
        fillContactInformation(phone, homePhone, salutation, lastName, department, assistant, leadSource);
        fillAdditionalInformation(languages, level);
    }

    private void fillContactInformation(
            String phone, String homePhone, String salutation, String lastName, String department,
            String assistant, String leadSource) {
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Home Phone").write(homePhone);
        new Picklist(driver, "Salutation").select(salutation);
        new Input(driver, "Last Name").write(lastName);
        new Input(driver, "Department").write(department);
        actions.scrollToElement(
                driver.findElement(By.xpath(String.format(TITLE_PATH, "Address Information")))).perform();
        new Input(driver, "Assistant").write(assistant);
        new Picklist(driver, "Lead Source").select(leadSource);
    }

    private void fillAdditionalInformation(String languages, String level) {
        actions.scrollToElement(
                driver.findElement(By.xpath(String.format(TITLE_PATH, "Additional Information")))).perform();
        new Input(driver, "Languages").write(languages);
        new Picklist(driver, "Level").select(level);
    }

    private void duplicateErrorWait() {
        try {
            driver.findElement(DUPLICATE_ERROR);
        } catch (NoSuchElementException e) {
        }
    }
}
