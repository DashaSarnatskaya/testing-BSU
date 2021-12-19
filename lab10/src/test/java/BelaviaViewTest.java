import model.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.LocationsCreator;

public class BelaviaViewTest extends CommonConditions {
    private final String EXPECTED_FLIGHT_NUMBER = "B2 736";
    private final String EXPECTED_ARRIVAL_TIME="09:10";

    @Test
    public void viewSuggestions() throws InterruptedException {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String flightNumber = homePage.openPage()
                .clickOnSuggestionsButton()
                .clickOnLocation()
                .getFlightNumber();
        System.out.println(flightNumber);
        Assert.assertEquals(EXPECTED_FLIGHT_NUMBER, flightNumber);
    }

    @Test
    public void viewTimetable() throws InterruptedException {
        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
        Location testLocations = LocationsCreator.locationsFromProperty();
        TimetableResultPage timetablePage = new TimetableResultPage(driver);
        belaviaHomePage.openPage()
                .clickOnMenuButton()
                .clickOnTimeTableButton()
                .clickOnOneWayButton()
                .clickOnDeparturePlace()
                .inputDeparturePlace(testLocations.getDeparturePlace())
                .clickOnDestinationPlace()
                .inputDestination(testLocations.getDestinationPlace())
                .clickOnCalendarButton()
                .clickOnDepartDateButton()
                .clickOnSearchButton();
        Assert.assertEquals(timetablePage.getArrivalTime(),EXPECTED_ARRIVAL_TIME);

    }
}
