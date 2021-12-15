package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BelaviaHomeResultPage extends AbstractPage {

    //private static final String RESULT_PAGE = "https://ibe.belavia.by/select?journeyType=Ow&journey=MSQMOW20220120&adults=1&children=0&infants=0&lang=ru";
    private final By flightNumberLocator = By.xpath("//div[text()='SVO']");
    public BelaviaHomeResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public BelaviaHomeResultPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }
    public String getFlightNumber() {
        return getElementListText(flightNumberLocator);
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

