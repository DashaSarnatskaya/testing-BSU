package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BelaviaHomeResultPage extends AbstractPage {

protected BelaviaHomeResultPage(WebDriver driver){
    super(driver);
}

    @Override
    protected WebElement defaultFindByLocator(By locator) {
        return super.defaultFindByLocator(locator);
    }

    @Override
    protected WebElement findByLocator(By locator) {
        return super.findByLocator(locator);
    }

    @Override
    protected WebElement findByLocatorAndClick(By locator) {
        return super.findByLocatorAndClick(locator);
    }
}

