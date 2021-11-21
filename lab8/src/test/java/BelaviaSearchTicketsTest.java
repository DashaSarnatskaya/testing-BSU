import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BelaviaSearchTicketsTest {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void browserSetup() {
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
}