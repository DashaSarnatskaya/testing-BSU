import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BelaviaFindTicketsTest {

    @Test
    public void viewTableOfArrivals()  {
        WebDriver driver=new ChromeDriver();
        BelaviaHomePage belaviaHomePage = new BelaviaHomePage(driver);
        belaviaHomePage.openPage();
        belaviaHomePage.inputPlaceOfDeparture("Минск");
        belaviaHomePage.inputDestination("Москва");
        belaviaHomePage.clickOnOneWayButton();
        belaviaHomePage.clickOnCalendarButton();
        belaviaHomePage.clickOnDateButton();
        belaviaHomePage.clickOnSearchButton();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.openResultPage();
        Assert.assertEquals(belaviaHomePage.getCurrentUrl(), resultPage.getCurrentUrl());
    }
}