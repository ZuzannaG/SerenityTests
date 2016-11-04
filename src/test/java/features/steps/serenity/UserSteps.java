package features.steps.serenity;

import net.thucydides.core.annotations.Step;
import pageObjects.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by testuser on 07/10/16.
 */
public class UserSteps {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Step
    public void opensHomePage() {
        homePage.open();
    }

    @Step
    public void clicksMyAccount() {
        homePage.clickMyAccount();
    }

    @Step
    public void clicksLogin() {
        homePage.clickLogin();
    }

    @Step
    public void isOnLoginPage() {
        assertTrue(loginPage.isDisplayed());
    }

    @Step
    public void entersUsername(String username) {
        loginPage.insertIntoUsernameField(username);
    }

    @Step
    public void entersPassword(String password) {
        loginPage.insertIntoPasswordField(password);
    }

    @Step
    public void clicksLoginButton() {
        loginPage.clickLogin();
    }

    @Step
    public void isOnMyAccountPage() {
        assertTrue(myAccountPage.isDisplayed());
    }

    @Step
    public void seesHeaderWithText(String text) {
        assertTrue(myAccountPage.getHeaderText().contains(text));
    }

    @Step
    public void seesErrorMessageWithText(String text) {
        assertEquals(text, loginPage.getErrorMessage());
    }
}
