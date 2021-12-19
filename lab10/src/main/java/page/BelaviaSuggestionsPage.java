package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BelaviaSuggestionsPage extends AbstractPage {
    private final By locationLocator = By.xpath("//a[contains(@href,'LED')]");

    public BelaviaSuggestionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }


    public BelaviaSuggestionsResultPage clickOnLocation() {
        WebElement element = findByLocator(locationLocator);
        element.click();
        return new BelaviaSuggestionsResultPage(driver);
    }
}
