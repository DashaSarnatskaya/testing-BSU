package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // protected abstract AbstractPage openPage();

    protected WebElement defaultFindByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    protected WebElement findByLocator(By locator) {
        try {
            return defaultFindByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return defaultFindByLocator(locator);
        }

    }

    protected WebElement findByLocatorAndClick(By locator) {
        try {
            WebElement element = defaultFindByLocator(locator);
            element.click();
            return element;
        } catch (StaleElementReferenceException e) {
            WebElement element = defaultFindByLocator(locator);
            element.click();
            return element;
        }
    }

}
