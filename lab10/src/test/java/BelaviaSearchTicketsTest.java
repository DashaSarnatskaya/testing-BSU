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

public class BelaviaSearchTicketsTest extends CommonConditions {
    // private WebDriver driver;
    private final String EXPECTED_FLIGHT_NUMBER = "SVO";

    @Test
    public void searchTicketsTest() throws InterruptedException {
        Location testLocations = LocationsCreator.locationsFromProperty();
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        homePage.openPage()
                .clickOnDeparturePlace()
                .inputDeparturePlace(testLocations.getDeparturePlace());
        Thread.sleep(2000);
        homePage.clickOnDestinationPlace()
                .inputDestination(testLocations.getDestinationPlace());
        Thread.sleep(2000);
        BelaviaHomeResultPage resultPage = homePage.clickOnOneWayButton()
                .clickOnCalendarButton()
                .clickOnDepartDateButton()
                .clickOnSearchButton();
        resultPage.openPage();

        String resultFlightNumber = resultPage.getFlightNumber();

        Assert.assertEquals(EXPECTED_FLIGHT_NUMBER, resultFlightNumber);
    }

}