package tests;

import org.testng.annotations.Test;
import utils.Retry;
import wrappers.Notification;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkCreateContact() {
        loginPage.login(user, password);
        newContactModal.open();
        newContactModal.createContact("+1234", "+4321", "Prof.", "Soprano",
                "DownTown", "Junior", "Web", "Italian", "Secondary");
        newContactModal.clickSaveButton();
        assertThat(new Notification(driver).getText())
                .contains("Contact \"Soprano\" was created.");
    }
}
