import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

import service.LocationsCreator;

public class BelaviaSearchTicketsTest extends CommonConditions {

    private final String EXPECTED_FLIGHT_NUMBER = "SVO";

    @Test
    public void searchTicketsTest() {
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
        resultPage.openPage();

        String resultFlightNumber = resultPage.getFlightNumber();

        Assert.assertEquals(EXPECTED_FLIGHT_NUMBER, resultFlightNumber);
    }

}