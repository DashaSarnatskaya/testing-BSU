import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

import service.LocationsCreator;

public class BelaviaSearchTicketsTest extends CommonConditions {

    private final String EXPECTED_AIRPORT = "SVO";
    private final String EXPECTED_PRICE = "132,73 BYN";
    private final String EXPECTED_ROUTE = "Минск - Москва";

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

        Assert.assertEquals(EXPECTED_AIRPORT, resultPage.getAirportName());
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

        Assert.assertEquals(EXPECTED_PRICE, resultPage.getPrice());

    }
}


