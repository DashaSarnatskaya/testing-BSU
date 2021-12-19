package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimetablePage extends AbstractPage {
    public static String TABLE_PAGE_URL = "https://ibe.belavia.by/";
    private WebDriver driver;

    private final By oneWayButton = By.xpath("//label[contains(@for,'journeyType_1')]");
    private final By departurePlaceInputLocator = By.xpath("//input[contains(@id,'origin')]");
    private final By destinationPlaceInputLocator = By.xpath("//input[contains(@id,'destination')]");
    private final By locationLocator = By.xpath("//div[contains(@class,'trigger-input')]//div[@class='trigger']");
    private final By calendarButton=By.xpath("//div[contains(@id,'departing')]");
    private final By departDateButton=By.xpath("//div[@class='month']//div[text()=26]");
    private final By searchButton=By.xpath("//button[@type='submit']");

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public TimetablePage clickOnOneWayButton() {
        findByLocator(oneWayButton).click();
        return this;
    }
    public TimetablePage clickOnDeparturePlace() {
        WebElement element = findByLocatorClickable(locationLocator);
        element.click();
        return this;
    }

    public TimetablePage clickOnDestinationPlace() {
        WebElement element = findAll(locationLocator).get(1);
        element.click();
        return this;
    }

    public TimetablePage inputDeparturePlace(String departurePlace) {
        WebElement element = findByLocator(departurePlaceInputLocator);
        element.sendKeys(departurePlace);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public TimetablePage inputDestination(String destinationPlace) {
        WebElement element = findByLocator(destinationPlaceInputLocator);
        element.sendKeys(destinationPlace);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
        return this;
    }
    public TimetablePage clickOnCalendarButton() {
        findByLocator(calendarButton).click();
        return this;
    }

    public TimetablePage clickOnDepartDateButton() {
        findByLocator(departDateButton).click();
        return this;
    }

    public TimetableResultPage clickOnSearchButton() {
        WebElement element = findByLocator(searchButton);
        element.click();
        return new TimetableResultPage(driver);
    }

}

