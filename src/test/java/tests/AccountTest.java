package tests;

import dto.Account;
import org.testng.annotations.Test;
import utils.Retry;

import static dto.AccountFactory.getAccount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkCreateAccountFactory() {
        Account account = getAccount("Warm", "Other", "Private", "Finance");
        loginPageFactory.open();
        loginPageFactory.login(user, password);
        accountStep.createAccount(account);
        assertThat(notificationPopUp.getText())
                .contains(String.format("Account \"%s\" was created.", account.getName()));
    }

    @Test
    public void checkCreateAccount() {
        Account account = getAccount("Warm", "Other", "Private", "Finance");
        loginStep.auth(user, password);
        accountStep.createAccount(account);
        assertThat(notificationPopUp.getText())
                .contains(String.format("Account \"%s\" was created.", account.getName()));
    }
}
