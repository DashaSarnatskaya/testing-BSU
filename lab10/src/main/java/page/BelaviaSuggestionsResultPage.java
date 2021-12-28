package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BelaviaSuggestionsResultPage extends AbstractPage {

    private final By flightNumberLocator = By.xpath("//span[text()='945']");

    public BelaviaSuggestionsResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public String getFlightNumber() {
        return getElementText(flightNumberLocator);
    }
}
