package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class BelaviaHomePage extends AbstractPage {
    public static String HOME_PAGE_URL = "https://belavia.by/";

    private static final Logger LOGGER = LogManager.getRootLogger();

    private By departurePlaceInputLocator = By.xpath("//*[@id='ibe']/form/div[1]/div[1]/div");
    private By destinationPlaceInputLocator = By.xpath("//*[@id='ibe']/form/div[1]/div[2]/div");
    private By oneWayButton = By.xpath("//label[@for = 'JourneySpan_Ow']");
    private By wayButton=By.xpath("//label[@for = 'JourneySpan_Rt']");
    private By calendarButton = By.xpath("//div[@class='wrapper ui-trigger-input ui-date-input'][1]//child::i");
    private By departDateButton = By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[4]/td[4]/a");
    private By returnDateButton = By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[4]/td[6]/a");
    private By searchButton = By.xpath("//button[@class='button btn-large btn btn-b2-green ui-corner-all']");
private By frameLocator=By.xpath("/html/body/noscript[1]/text()");


    public BelaviaHomePage(WebDriver driver) {

       super(driver);
       //LOGGER.log(Level.INFO,"Home page is opened");

    }

    public BelaviaHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }




    public BelaviaHomePage inputDeparturePlace(String departurePlace) {
        findByLocator(departurePlaceInputLocator).sendKeys(departurePlace);
        return this;
    }

    public BelaviaHomePage inputDestinationPlace(String destinationPlace) {
        findByLocator(destinationPlaceInputLocator).sendKeys(destinationPlace);
        return this;
    }

    public BelaviaHomePage clickOnWayButton(){
        findByLocatorAndClick(wayButton);
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
        findByLocator(departDateButton).click();
        return this;
    }

    public BelaviaHomePage clickOnSearchButton() {
        findByLocator(searchButton).click();
        return this;
    }

    public BelaviaHomePage enterDate(String departDate, String returnDate){
        findByLocatorAndClick(calendarButton);
        findByLocatorAndClick(departDateButton).sendKeys(departDate);
        findByLocatorAndClick(returnDateButton).sendKeys(returnDate);
        return this;
    }
    public boolean isInitialized(By locator) {
        return findByLocator(locator).isDisplayed();
    }
public BelaviaHomePage enterLocation(String departurePlace, String destinationPlace){
        findByLocatorAndClick(departurePlaceInputLocator).sendKeys(departurePlace);
        findByLocatorAndClick(destinationPlaceInputLocator).sendKeys(destinationPlace);
        return this;
}
    public BelaviaHomePage clickOnSuggestionsButton() {
        findByLocator(searchButton);
        return this;
    }
    public BelaviaHomeResultPage searchTickets(){
        findByLocatorAndClick(searchButton);
        return new BelaviaHomeResultPage(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
