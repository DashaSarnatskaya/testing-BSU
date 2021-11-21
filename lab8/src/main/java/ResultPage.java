import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver driver;
    private static final String RESULT_PAGE = "https://ibe.belavia.by/select?journeyType=Ow&journey=MSQMOW20211223&adults=1&children=0&infants=0&lang=ru";

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage openResultPage() {
        driver.get(RESULT_PAGE);
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
