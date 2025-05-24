package tests;

import org.testng.annotations.Test;
import utils.Retry;
import wrappers.Notification;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkCreateAccount() {
        loginPage.login(user, password);
        newAccountModal.open();
        newAccountModal.createAccount("Stas", "Warm", "+12345678", "1234",
                "+1234567", "www.test.com", "wwwtest", "1234",
                "Other", "Private", "Finance", false, true,
                "21 jump street", "Brest", "12345", "Belarus",
                "По просьбе своего адвоката Тони проводит время в своей законной карьере " +
                        "по управлению отходами. Ричи и Джуниор идут на риск, чтобы поддерживать " +
                        "прибыльную кокаиновую сеть. Здоровье Тони ухудшается, как и здоровье доктора " +
                        "Мелфи. Джуниор воссоединяется со старой подругой, находясь под домашним арестом.");
        newAccountModal.clickSaveButton();
        assertThat(new Notification(driver).getText())
                .contains("Account \"Stas\" was created.");
    }
}
