import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;

public class DepartureBoardTest extends CommonConditions {
    private final static String EXPECTED_AIRPLANEE_TYPE = "Boeing 737-800";

    @Test
    public void showDepartureBoard() {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String airplaneType = homePage.openPage()
                .clickOnMenuButton()
                .clickOnDepartBoard()
                .clickOnCalendar()
                .clickOnDate()
                .clickOnBoarType()
                .clickOnShowButton()
                .getAirplaneType();

        Assert.assertEquals(airplaneType, EXPECTED_AIRPLANEE_TYPE);
    }
}
