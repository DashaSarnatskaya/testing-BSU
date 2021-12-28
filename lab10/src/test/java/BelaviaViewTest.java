import model.Location;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.TimetableResultPage;
import service.LocationsCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class BelaviaViewTest extends CommonConditions {

    private final String EXPECTED_TIME = "09:00";

    @Test
    public void viewSuggestions() {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String flightNumber = homePage.openPage()
                .clickOnSuggestionsButton()
                .clickOnLocation()
                .getFlightNumber();

        assertThat(flightNumber).contains("945");
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

        assertThat(timetablePage.getArrivalTime()).isGreaterThan(EXPECTED_TIME);

    }
}
