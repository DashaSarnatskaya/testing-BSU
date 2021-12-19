package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimetablePage {
    public static String TABLE_PAGE_URL = "https://ibe.belavia.by/";
    private WebDriver driver;

    private By wayButton = By.xpath("//label[@for = 'journeyType_0']");
    private By placeOfDepartureInputLocator = By.xpath("//input[@id='origin']");
    private By destinationInputLocator = By.xpath("//input[@id='destination']");

    private By tudaCalendarButton = By.xpath("//*[@id='departing']");
    private By obratnoCalendarButton = By.xpath("//*[@id='returning']");

    private By searchButton = By.xpath("//button[text()='Найти']");


    private By menuButton = By.xpath("//a[@id='select-main-menu']");
    private By timetableButton = By.xpath("//a[text()='Расписание рейсов']");

    public TimetablePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByLocator(By locator) {
        return new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public TimetablePage inputPlaceOfDeparture(String placeOfDeparture) {
        findByLocator(placeOfDepartureInputLocator).sendKeys(placeOfDeparture);
        return this;
    }

    public TimetablePage inputDestination(String destination) {
        findByLocator(destinationInputLocator).sendKeys(destination);
        return this;
    }


    public TimetablePage clickOnOneWayButton() {
        findByLocator(wayButton).click();
        return this;
    }

    public TimetablePage clickOnTudaCalendarButton() {
        findByLocator(tudaCalendarButton).click();
        return this;
    }

    public TimetablePage clickOnObratnoCalendarButton() {
        findByLocator(obratnoCalendarButton).click();
        return this;
    }

}
