import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

import page.TimetableResultPage;
import service.LocationsCreator;

public class HomePageTests extends CommonConditions {

    private final String EXPECTED_AIRPORT = "SVO";
    private final String EXPECTED_PRICE = "132,73 BYN";
    private final String EXPECTED_FLIGHT_NUMBER = "B2 942";
    private final String EXPECTED_ARRIVAL_TIME = "09:10";

    @Test
    public void searchTicketsOnWayTripTest() {
        Location testLocations = LocationsCreator.locationsFromProperty();
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        BelaviaHomeResultPage resultPage = homePage.openPage()
                .clickOnDeparturePlace()
                .inputDeparturePlace(testLocations.getDeparturePlace())
                .clickOnDestinationPlace()
                .inputDestination(testLocations.getDestinationPlace())
                .clickOnOneWayButton()
                .clickOnCalendarButton()
                .clickOnDepartDateButton()
                .clickOnSearchButton();

        Assert.assertEquals(resultPage.getAirportName(), EXPECTED_AIRPORT);
    }

    @Test
    public void searchTicketsRoundTripTest() {
        Location testLocations = LocationsCreator.locationsFromProperty();
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        BelaviaHomeResultPage resultPage = homePage.openPage()
                .clickOnDeparturePlace()
                .inputDeparturePlace(testLocations.getDeparturePlace())
                .clickOnDestinationPlace()
                .inputDestination(testLocations.getDestinationPlace())
                .clickOnRoundTripButton()
                .clickOnDepartDateButton()
                .clickOnReturnDateButton()
                .clickOnSearchButton();

        Assert.assertEquals(resultPage.getPrice(), EXPECTED_PRICE);

    }

    @Test
    public void viewSuggestions() throws InterruptedException {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String flightNumber = homePage.openPage()
                .clickOnSuggestionsButton()
                .clickOnLocation()
                .getFlightNumber();
        Assert.assertEquals(flightNumber,EXPECTED_FLIGHT_NUMBER);
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
        Assert.assertEquals( timetablePage.getArrivalTime(),EXPECTED_ARRIVAL_TIME);

    }
}


