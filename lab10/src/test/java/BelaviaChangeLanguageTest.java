import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;

public class BelaviaChangeLanguageTest extends CommonConditions {
    private final String url = "https://en.belavia.by/";

    @Test
    public void changeLanguage() {
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        BelaviaHomeResultPage resultPage = homePage.openPage()
                .clickOnLanguageButton()
                .clickOnEnLangButton();
        Assert.assertEquals(resultPage.getCurrentUrl(), url);
    }
}
