import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

import service.LocationsCreator;

public class BelaviaSearchTicketsTest extends CommonConditions {

    private final String EXPECTED_AIRPORT = "SVO";
    private final String EXPECTED_PRICE = "140,46 BYN";

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
//
//        String resultFlightNumber = resultPage.getFlightNumber();
//        System.out.println(resultPage.getFlightNumber());
//        Assert.assertEquals(EXPECTED_AIRPORT, resultFlightNumber);
        String rezPrice = resultPage.getPrice();
        Assert.assertEquals(EXPECTED_PRICE,rezPrice);
    }

}