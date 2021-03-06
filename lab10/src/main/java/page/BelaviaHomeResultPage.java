package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BelaviaHomeResultPage extends AbstractPage {

    private final By flightNumberLocator = By.xpath("//div[text()='SVO']");
    private final By priceForEconomTicketsLocator = By.xpath("//div[@class='price-value']");
    private final By routeLocator = By.xpath("//div[contains(@class, 'h2')]");
    private final By userNameLocator = By.xpath("//span[text()='TATSIANA SHUBENOK']");

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
        return getElementText(flightNumberLocator);
    }

    public String getPrice() {
        return findAll(priceForEconomTicketsLocator).get(3).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getUserName() {
        return getElementText(userNameLocator);
    }
}

