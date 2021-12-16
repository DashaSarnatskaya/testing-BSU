package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BelaviaSuggestionsResultPage extends AbstractPage{

    private final By flightNumberLocator=By.xpath("//*[@id='body']/div/div[2]/div/form/div[1]/div[4]/div/div[1]/div[1]/div[2]/div/div/span");
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
