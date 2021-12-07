import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BelaviaSearchTicketsTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }


    @Test
    public void searchTicketsTest() {

        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
        belaviaHomePage.openPage();
        belaviaHomePage.inputPlaceOfDeparture("Минск");
        belaviaHomePage.inputDestination("Москва");
        belaviaHomePage.clickOnOneWayButton();
        belaviaHomePage.clickOnCalendarButton();
        belaviaHomePage.clickOnDateButton();
        belaviaHomePage.clickOnSearchButton();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.openResultPage();
        Assert.assertEquals(belaviaHomePage.getCurrentUrl(), resultPage.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}