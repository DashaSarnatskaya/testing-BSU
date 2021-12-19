import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.TimetablePage;

public class BelaviaViewTest extends CommonConditions {
    private final String EXPECTED_FLIGHT_NUMBER = "B2 736";

    @Test
    public void viewSuggestions() throws InterruptedException {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        String flightNumber = homePage.openPage()
                .clickOnSuggestionsButton()
                .clickOnLocation()
                .getFlightNumber();
        Assert.assertEquals(EXPECTED_FLIGHT_NUMBER, flightNumber);
    }

    @Test
    public void viewTimetable() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
        TimetablePage timetablePage = new TimetablePage(driver);
        belaviaHomePage.openPage();
        Thread.sleep(2000);
        //belaviaHomePage.clickOnMenuButton();
        Thread.sleep(2000);
        //belaviaHomePage.clickOnTimetableButton();
        Thread.sleep(2000);
        timetablePage.clickOnOneWayButton();
        Thread.sleep(2000);
        timetablePage.clickOnTudaCalendarButton();
        Thread.sleep(2000);
        timetablePage.clickOnObratnoCalendarButton();
        // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='select-main-menu']"))).click();
    }
}
