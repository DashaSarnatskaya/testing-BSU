import org.testng.annotations.Test;
import page.BelaviaHomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartureBoardTest extends CommonConditions {

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

        assertThat(airplaneType).doesNotEndWith("5");
    }
}
