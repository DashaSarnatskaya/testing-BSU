import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BelaviaHomePage {
    public static String TABLE_PAGE_URL = "https://belavia.by/";
    private WebDriver driver;

    private By placeOfDepartureInputLocator = By.xpath("//input[@name='OriginLocation_Combobox']");
    private By destinationInputLocator = By.xpath("//input[@name='DestinationLocation_Combobox']");
    private By oneWayButton = By.xpath("//label[@for = 'JourneySpan_Ow']");
    private By calendarButton = By.xpath("//*[@id='step-2']/div[2]/div[1]/div/a/i");
    private By dateButton = By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[4]/td[4]/a");
    private By searchButton = By.xpath("//button[@class='button btn-large btn btn-b2-green ui-corner-all']");

    public BelaviaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public BelaviaHomePage openPage() {
        driver.get(TABLE_PAGE_URL);
        return this;
    }

    public WebElement findByLocator(By locator) {
        return new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public BelaviaHomePage inputPlaceOfDeparture(String placeOfDeparture) {
        findByLocator(placeOfDepartureInputLocator).sendKeys(placeOfDeparture);
        return this;
    }

    public BelaviaHomePage inputDestination(String destination) {
        findByLocator(destinationInputLocator).sendKeys(destination);
        return this;
    }


    public BelaviaHomePage clickOnOneWayButton() {
        findByLocator(oneWayButton).click();
        return this;
    }

    public BelaviaHomePage clickOnCalendarButton() {
        findByLocator(calendarButton).click();
        return this;
    }

    public BelaviaHomePage clickOnDateButton() {
        findByLocator(dateButton).click();
        return this;
    }

    public BelaviaHomePage clickOnSearchButton() {
        findByLocator(searchButton).click();
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
