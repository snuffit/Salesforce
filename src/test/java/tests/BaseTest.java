package tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import steps.AccountStep;
import steps.ContactStep;
import steps.LoginStep;
import utils.TestListener;

import java.time.Duration;

import static utils.AllureUtils.takeScreenshot;
import static utils.DriverFactory.*;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    Dotenv dotenv;
    String user;
    String password;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    LoginPageFactory loginPageFactory;
    HomePage homePage;
    LoginStep loginStep;
    AccountStep accountStep;
    NotificationPopUp notificationPopUp;
    ContactStep contactStep;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Открытие браузера")
    public void setup(@Optional("chrome") String browser) {
        createDriver(browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        softAssert = new SoftAssert();
        dotenv = Dotenv.load();
        user = dotenv.get("USER");
        password = dotenv.get("PASSWORD");
        loginPage = new LoginPage(getDriver());
        newAccountModal = new NewAccountModal(getDriver());
        newContactModal = new NewContactModal(getDriver());
        loginPageFactory = new LoginPageFactory(getDriver());
        homePage = new HomePage(getDriver());
        loginStep = new LoginStep(getDriver());
        accountStep = new AccountStep(getDriver());
        notificationPopUp = new NotificationPopUp(getDriver());
        contactStep = new ContactStep(getDriver());
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(getDriver());
        }
        quitDriver();
    }
}
