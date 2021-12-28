import model.Location;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;
import service.LocationsCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTicketsTest extends CommonConditions {

    private final String EXPECTED_PRICE = "150 BYN";

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
                .clickOnDepartDateButton()
                .clickOnSearchButton();

        assertThat(resultPage.getAirportName()).doesNotContainAnyWhitespaces();
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

        assertThat(resultPage.getPrice()).isLessThan(EXPECTED_PRICE);
    }


}
