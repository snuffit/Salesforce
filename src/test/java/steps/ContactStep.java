package steps;

import dto.Contact;
import org.openqa.selenium.WebDriver;
import pages.NewContactModal;

public class ContactStep {

    WebDriver driver;
    NewContactModal newContactModal;

    public ContactStep(WebDriver driver) {
        this.driver = driver;
        newContactModal = new NewContactModal(driver);
    }

    public void createContact(Contact contact){
        newContactModal.open()
                .isPageOpend()
                .createContact(contact)
                .clickSaveButton();
    }
}
