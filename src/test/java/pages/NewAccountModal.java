package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

    private final String URI = "https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new",
            TITLE_PATH = "//span[text()='%s']";
    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']"),
            DUPLICATE_ERROR = By.xpath("//*[text()='Similar Records Exist']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void open() {
        wait.until(driver -> {
            return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete");
        });
        driver.get(URI);
    }

    public void createAccount(String name, String rating, String phone, String fax, String accountNumber,
                              String website, String accountSite, String tickerSymbol, String type,
                              String ownership, String industry, boolean isVipClient, boolean isTeachMeSkills,
                              String billingStreet, String billingCity, String billingZip,
                              String billigCountry, String description) {
        fillAccountInformation(name, rating, phone, fax, accountNumber, website, accountSite, tickerSymbol, type,
                ownership, industry, isVipClient, isTeachMeSkills);
        fillAddressInformation(billingStreet, billingCity, billingZip, billigCountry);
        fillDescriptionInformation(description);
    }

    public void clickSaveButton() {
        duplicateErrorWait();
        driver.findElement(SAVE_BUTTON).click();
    }

    private void fillAccountInformation(
            String name, String rating, String phone, String fax, String accountNumber,
            String website, String accountSite, String tickerSymbol, String type,
            String ownership, String industry, boolean isVipClient, boolean isTeachMeSkills) {
        new Input(driver, "Account Name").write(name);
        new Picklist(driver, "Rating").select(rating);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Account Number").write(accountNumber);
        new Input(driver, "Website").write(website);
        new Input(driver, "Account Site").write(accountSite);
        new Input(driver, "Ticker Symbol").write(tickerSymbol);
        new Picklist(driver, "Type").select(type);
        new Picklist(driver, "Ownership").select(ownership);
        actions.scrollToElement(
                driver.findElement(By.xpath(String.format(TITLE_PATH, "Address Information")))).perform();
        new Picklist(driver, "Industry").select(industry);
        new Checkbox(driver, "VIP Client").select(isVipClient);
        new Checkbox(driver, "TeachMeSkills").select(isTeachMeSkills);
    }

    private void fillAddressInformation(String billingStreet, String billingCity,
                                        String billingZip, String billigCountry) {
        actions.scrollToElement(
                driver.findElement(By.xpath(String.format(TITLE_PATH, "Additional Information")))).perform();
        new TextArea(driver, "Billing Street").write(billingStreet);
        new Input(driver, "Billing City").write(billingCity);
        new Input(driver, "Billing Zip/Postal Code").write(billingZip);
        new Input(driver, "Billing Country").write(billigCountry);
    }

    private void fillDescriptionInformation(String description) {
        actions.scrollToElement(new TextArea(driver, "Description").get()).perform();
        new TextArea(driver, "Description").write(description);
    }

    private void duplicateErrorWait() {
        try {
            driver.findElement(DUPLICATE_ERROR);
        } catch (NoSuchElementException e) {
        }
    }
}
