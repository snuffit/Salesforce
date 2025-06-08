package pages;

import dto.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.Picklist;

public class NewContactModal extends BasePage {

    private final String URI = BASE_URL + "lightning.force.com/lightning/o/Contact/new",
            TITLE_PATH = "//span[text()='%s']";
    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']"),
            DUPLICATE_ERROR = By.xpath("//*[text()='Similar Records Exist']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal open() {
        waitForPageLoaded();
        driver.get(URI);
        return this;
    }

    @Override
    public NewContactModal isPageOpend() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SAVE_BUTTON)));
        return this;
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public NewContactModal createContact(Contact contact) {
        fillContactInformation(contact.getPhone(), contact.getHomePhone(), contact.getSalutation(),
                contact.getLastName(), contact.getDepartment(), contact.getAssistant(), contact.getLeadSource());
        fillAdditionalInformation(contact.getLanguages(), contact.getLevel());
        return this;
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
}
