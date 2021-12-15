import model.Date;
import model.Location;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;
import service.DatesCreator;
import service.LocationsCreator;

public class BelaviaSearchTicketsTest extends CommonConditions{
    // private WebDriver driver;

@BeforeMethod(alwaysRun = true)
// public void setupDriver() {
//       ChromeOptions options = new ChromeOptions();
//     options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
//       driver = new ChromeDriver(options);
//  }

//    @Test
//    public void searchTicketsOneWayTest()  throws InterruptedException {
//        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
//        belaviaHomePage.openPage();
//        belaviaHomePage.inputDeparturePlace();
//        Thread.sleep(2000);
//        belaviaHomePage.inputDestinationPlace();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnOneWayButton();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnCalendarButton();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnDepartDateButton();
//        Thread.sleep(2000);
//        belaviaHomePage.clickOnSearchButton();
//        Thread.sleep(2000);
//
//        BelaviaHomeResultPage resultPage = new BelaviaHomeResultPage(driver);
//        resultPage.openResultPage();
//        Assert.assertEquals(belaviaHomePage.getCurrentUrl(), resultPage.getCurrentUrl());
//    }

    @Test
    public void searchTicketsTest(){
        Location testLocations = LocationsCreator.locationsFromProperty();
        Date testDates= DatesCreator.datesFromProperty();
        BelaviaHomePage homePage=new BelaviaHomePage(driver);
        homePage.openPage()
                .enterLocation(testLocations.getDeparturePlace(),testLocations.getDestinationPlace())
                .clickOnWayButton()
                .enterDate(testDates.getDepartDate(),testDates.getReturnDate());
        homePage.searchTickets();
        //Assert.assertTrue(homePage.isSa);
    }

//    @AfterMethod(alwaysRun = true)
//    public void closeBrowser(){
//        driver.quit();
//    }
}