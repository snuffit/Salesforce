package steps;

import dto.Account;
import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;

public class AccountStep {

    WebDriver driver;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountModal = new NewAccountModal(driver);
    }

    public void createAccount(Account account){
        newAccountModal.open()
                .isPageOpend()
                .createAccount(account)
                .clickSaveButton();
    }
}
