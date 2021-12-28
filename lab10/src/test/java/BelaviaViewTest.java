import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.TimetableResultPage;
import service.LocationsCreator;

public class BelaviaViewTest extends CommonConditions {


    private final String EXPECTED_FLIGHT_NUMBER = "B2 945";
    private final String EXPECTED_ARRIVAL_TIME = "10:00";


    @Test
    public void viewSuggestions() {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String flightNumber = homePage.openPage()
                .clickOnSuggestionsButton()
                .clickOnLocation()
                .getFlightNumber();
        Assert.assertEquals(flightNumber, EXPECTED_FLIGHT_NUMBER);
    }

    @Test
    public void viewTimetable() {
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
        Assert.assertEquals(timetablePage.getArrivalTime(), EXPECTED_ARRIVAL_TIME);

    }
}
