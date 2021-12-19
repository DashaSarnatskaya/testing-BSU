import model.Location;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;
import service.LocationsCreator;
import service.UserCreator;

public class BelaviaLogInTest extends CommonConditions {

    private final String EXPECTED_USER_NAME="TATSIANA SHUBENOK";

    @Test
    public void LogInTest() {
        User user = new UserCreator().withCredentialsFromProperty();
        BelaviaHomePage homePage = new BelaviaHomePage(driver);
        BelaviaHomeResultPage resultPage = homePage.openPage()
                .clickOnLogInButton()
                .clickOnMemberId()
                .inputMemberId(user.getMemberId())
                .clickOnPassword()
                .inputPassword(user.getPassword())
                .clickOnSingInButton();
        resultPage.openPage();
        String resultUserName=resultPage.getUserName();
        Assert.assertEquals(EXPECTED_USER_NAME,resultUserName);

    }

}
