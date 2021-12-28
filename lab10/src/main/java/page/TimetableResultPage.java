package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimetableResultPage extends AbstractPage {

    private final By arrivalTime = By.xpath("//div[@class='time']");

    public TimetableResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public String getArrivalTime() {
        return findAll(arrivalTime).get(3).getText();
    }
}
