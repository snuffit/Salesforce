package tests;

import dto.Contact;
import org.testng.annotations.Test;
import utils.Retry;

import static dto.ContactFactory.getContact;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkCreateContact() {
        Contact contact = getContact("Prof.", "Web", "Secondary");
        loginStep.auth(user, password);
        contactStep.createContact(contact);
        assertThat(notificationPopUp.getText()).contains(String.format(
                "Contact \"%s %s\" was created.", contact.getSalutation(), contact.getLastName()));
    }
}
