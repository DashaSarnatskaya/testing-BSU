import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BelaviaHomePage {
    public static String TABLE_PAGE_URL = "https://belavia.by/";
    private WebDriver driver;

    private By placeOfDepartureInputLocator = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[1]/div[1]/div/input");
    private By destinationInputLocator= By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[1]/div[2]/div/input");
    private By oneWayButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[1]/div/label[1]");
    private By calendarButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[2]/div[1]/div/a/i");
    private By dateButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div/div[2]/table/tbody/tr[4]/td[4]/a");
    private By searchButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[4]/div/button");

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
    public BelaviaHomePage inputDestination (String destination) {
        findByLocator(destinationInputLocator).sendKeys(destination);
        return this;
    }


     public BelaviaHomePage clickOnOneWayButton(){
        findByLocator(oneWayButton).click();
        return this;
     }
    public BelaviaHomePage clickOnCalendarButton(){
        findByLocator(calendarButton).click();
        return this;
    }
    public BelaviaHomePage clickOnDateButton(){
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
