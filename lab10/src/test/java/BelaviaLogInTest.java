import model.User;
import org.testng.annotations.Test;
import page.BelaviaHomePage;
import page.BelaviaHomeResultPage;
import service.UserCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class BelaviaLogInTest extends CommonConditions {

    private final String EXPECTED_USER_NAME = "TATSIANA SHUBENOK";

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
        assertThat(resultPage.getUserName()).isEqualTo(EXPECTED_USER_NAME);
    }

}
