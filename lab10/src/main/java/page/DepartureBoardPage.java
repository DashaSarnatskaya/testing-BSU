package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepartureBoardPage extends AbstractPage {

    private final By calendarButton = By.xpath("//div[contains(@class,'ui-date-input')]//a[contains(@class,'trigger')]");
    private final By dateLocator = By.xpath("//a[text()='21']");
    private final By showButton = By.xpath("//button[@id='getFlightStatus']");
    private final By boardTypeButton = By.xpath("//label[@for='board-type-2']");
    private final By airplaneType = By.xpath("//div[@class='td plane']");

    public DepartureBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public DepartureBoardPage clickOnCalendar() {
        findByLocatorClickable(calendarButton).click();
        return this;
    }

    public DepartureBoardPage clickOnDate() {
        findByLocator(dateLocator).click();
        return this;
    }

    public DepartureBoardPage clickOnBoarType() {
        findByLocator(boardTypeButton).click();
        return this;
    }

    public DepartureBoardPage clickOnShowButton() {
        findByLocator(showButton).click();
        return this;
    }

    public String getAirplaneType() {
        return getElementText(airplaneType);
    }
}
