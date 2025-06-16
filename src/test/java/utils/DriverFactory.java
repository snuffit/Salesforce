package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void createDriver(String browser) {
        if (driverThreadLocal.get() == null) {
            WebDriver driver;
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();
                driverThreadLocal.set(driver);
            } else if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
                driverThreadLocal.set(driver);
            }
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        driver.quit();
        driverThreadLocal.remove();
    }
}
