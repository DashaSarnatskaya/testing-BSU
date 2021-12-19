package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BelaviaSuggestionsResultPage extends AbstractPage {

    private final By flightNumberLocator = By.xpath("//span[text()='736']");

    public BelaviaSuggestionsResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFlightNumber() {
        return getElementText(flightNumberLocator);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
