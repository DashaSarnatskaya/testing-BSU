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
    private final By roundTripButton = By.xpath("//label[@for = 'JourneySpan_Rt']");
    private final By calendarButton = By.xpath("//div[contains(@class,'ui-date-input')]//a[contains(@class,'trigger')]");
    private final By departDateButton = By.xpath("//td[@data-year='2022']//a[text()='20']");
    private final By returnDateButton = By.xpath("//td[@data-year='2022']//a[text()='22']");
    private final By searchButton = By.xpath("//button[contains(@onclick,'kupit')]");
    private final By suggestionsButton = By.xpath("//div[@class='offers clear']//a[contains(@href,'/predlozheniya/')]");
    private final By languageButton = By.xpath("//a[@id='select-lang']");
    private final By enLangButton = By.xpath("//a[@data-iso='EN']");
    private final By logInButton = By.xpath("//a[contains(@id, 'select-member')]");
    private final By memberLocator = By.xpath("//label[contains(@for,'MemberId')]");
    private final By passwordLocator = By.xpath("//label[contains(@for,'Password')]");
    private final By memberIdInputLocator = By.xpath("//input[contains(@id, 'MemberId')]");
    private final By passwordInputLocator = By.xpath("//input[contains(@id, 'Password')]");
    private final By singInButton = By.xpath("//button[contains(@class, 'login')]");
    private final By menuButton = By.xpath("//a[contains(@id,'main-menu')]");
    private final By timetableButton = By.xpath("//a[contains(@href,'/time-table/')]");
    private final By departBoardButton = By.xpath("//a[contains(@href,'/table/')]");

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

    public BelaviaHomePage clickOnRoundTripButton() {
        findByLocator(roundTripButton).click();
        return this;
    }

    public BelaviaHomePage clickOnCalendarButton() {
        findByLocatorClickable(calendarButton).click();
        return this;
    }

    public BelaviaHomePage clickOnDepartDateButton() {
        findByLocator(departDateButton).click();
        return this;
    }

    public BelaviaHomePage clickOnReturnDateButton() {
        findByLocator(returnDateButton).click();
        return this;
    }

    public BelaviaHomeResultPage clickOnSearchButton() {
        WebElement element = findByLocator(searchButton);
        element.click();
        return new BelaviaHomeResultPage(driver);
    }

    public BelaviaSuggestionsPage clickOnSuggestionsButton() {
        WebElement element = findByLocator(suggestionsButton);
        element.click();
        return new BelaviaSuggestionsPage(driver);
    }

    public BelaviaHomePage clickOnLanguageButton() {
        findByLocator(languageButton).click();
        return this;
    }

    public BelaviaHomeResultPage clickOnEnLangButton() {
        WebElement element = findByLocator(enLangButton);
        element.click();
        return new BelaviaHomeResultPage(driver);
    }

    public BelaviaHomePage clickOnLogInButton() {
        findByLocator(logInButton).click();
        return this;
    }

    public BelaviaHomePage clickOnMemberId() {
        findByLocatorClickable(memberLocator);
        return this;
    }

    public BelaviaHomePage clickOnPassword() {
        findByLocatorClickable(passwordLocator);
        return this;
    }

    public BelaviaHomePage inputMemberId(String memberId) {
        WebElement element = findByLocator(memberIdInputLocator);
        element.sendKeys(memberId);
        return this;
    }

    public BelaviaHomePage inputPassword(String password) {
        WebElement element = findByLocator(passwordInputLocator);
        element.sendKeys(password);
        return this;
    }

    public BelaviaHomeResultPage clickOnSingInButton() {
        WebElement element = findByLocator(singInButton);
        element.click();
        return new BelaviaHomeResultPage(driver);
    }

    public BelaviaHomePage clickOnMenuButton() {
        WebElement element = findByLocator(menuButton);
        element.click();
        return this;
    }

    public TimetablePage clickOnTimeTableButton() {
        WebElement element = findByLocator(timetableButton);
        element.click();
        return new TimetablePage(driver);
    }

    public DepartureBoardPage clickOnDepartBoard() {
        WebElement element = findByLocator(departBoardButton);
        element.click();
        return new DepartureBoardPage(driver);
    }
}
