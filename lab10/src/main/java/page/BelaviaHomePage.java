package page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BelaviaHomePage extends AbstractPage {

    public static String HOME_PAGE_URL = "https://belavia.by/";

    private final By destinationPlaceInputLocator = By.xpath("//input[@id='DestinationLocation_Combobox']");
    private final By departurePlaceInputLocator = By.xpath("//input[@id='OriginLocation_Combobox']");
    private final By locationLocator = By.xpath("//a[@class='trigger']");
    private final By oneWayButton = By.xpath("//label[@for = 'JourneySpan_Ow']");
    private final By wayButton = By.xpath("//label[@for = 'JourneySpan_Rt']");
    private final By calendarButton = By.xpath("//div[@class='wrapper ui-trigger-input ui-date-input'][1]//child::i");
    private final By departDateButton = By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[4]/td[4]/a");
    private final By returnDateButton = By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[4]/td[6]/a");
    private final By searchButton = By.xpath("//button[@class='button btn-large btn btn-b2-green ui-corner-all']");

    public BelaviaHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BelaviaHomePage openPage() {
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }


    public BelaviaHomePage clickOnDeparturePlace() {
        WebElement element = findByLocatorClickable(locationLocator);
        element.click();
        return this;
    }

    public BelaviaHomePage clickOnDestinationPlace() {
        WebElement element = findAll(locationLocator).get(1);
        element.click();
        return this;
    }

    public BelaviaHomePage inputDeparturePlace(String departurePlace) {
        WebElement element = findByLocator(departurePlaceInputLocator);
        element.sendKeys(departurePlace);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public BelaviaHomePage inputDestination(String destinationPlace) {
        WebElement element = findByLocator(destinationPlaceInputLocator);
        element.sendKeys(destinationPlace);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ARROW_UP);
        element.sendKeys(Keys.ENTER);
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

    public BelaviaHomePage clickOnDepartDateButton() {
        findByLocatorClickable(departDateButton).click();
        return this;
    }

    public BelaviaHomeResultPage clickOnSearchButton() {
        WebElement element = findByLocator(searchButton);
        element.click();
        return new BelaviaHomeResultPage(driver);
    }

}
