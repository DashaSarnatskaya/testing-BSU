package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            if ("firefox".equals(System.getProperty("browser"))) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
