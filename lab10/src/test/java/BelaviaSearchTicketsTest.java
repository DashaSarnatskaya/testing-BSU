import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

import service.LocationsCreator;

public class BelaviaSearchTicketsTest extends CommonConditions {

    private final String EXPECTED_AIRPORT = "SVO";
    private final String EXPECTED_PRICE = "140,46 BYN";
    private final String EXPECTED_ROUTE = "Минск - Москва";

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
        Assert.assertEquals(EXPECTED_AIRPORT, resultFlightNumber);
    }

    @Test
    public void searchTicketsRoundTripTest(){
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
        resultPage.openPage();

        String resultRoute=resultPage.getRoute();
        System.out.println(resultRoute);
        Assert.assertEquals(EXPECTED_ROUTE,resultRoute);

    }


}