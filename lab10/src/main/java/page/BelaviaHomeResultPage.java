package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BelaviaHomeResultPage extends AbstractPage {

    private final By flightNumberLocator = By.xpath("//div[text()='SVO']");
    private final By priceForEconomTicketsLocator=By.xpath("//div[@class='price-value']");
    private final By routeLocator=By.xpath("//div[contains(@class, 'h2')]");
    private final By userNameLocator=By.xpath("//span[text()='TATSIANA SHUBENOK']");

    public BelaviaHomeResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BelaviaHomeResultPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public String getAirportName() {
        return getElementListText(flightNumberLocator);
    }
    public String getPrice(){return getElementListText(priceForEconomTicketsLocator);}
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getRoute(){
        return getElementListText(routeLocator);
    }
public String getUserName(){
        return getElementText(userNameLocator);
}
    @Override
    protected WebElement findByLocator(By locator) {
        return super.findByLocator(locator);
    }

    @Override
    protected WebElement findByLocatorClickable(By locator) {
        return super.findByLocatorClickable(locator);
    }

    @Override
    protected List<WebElement> findAll(By locator) {
        return super.findAll(locator);
    }
}

