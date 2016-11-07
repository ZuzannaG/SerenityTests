package features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by testuser on 04/11/16.
 */
public class LoginSteps {

    @Steps
    UserSteps user;

    @Given("^I am on the landing page$")
    public void iAmOnTheLandingPage() {
        user.opensHomePage();
    }

    @When("^I click on My Account button$")
    public void iClickOnMyAccountButton() {
        user.clicksMyAccount();
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        user.clicksLogin();
    }

    @Then("^I am on the Login page$")
    public void iAmOnTheLoginPage() {
        user.isOnLoginPage();
    }

    @When("^I enter \"([^\"]*)\" in the username field$")
    public void iEnterInTheUsernameField(String username) {
        user.entersUsername(username);
    }

    @And("^I enter \"([^\"]*)\" in the password field$")
    public void iEnterInThePasswordField(String password) {
        user.entersPassword(password);
    }

    @And("^I click Login button$")
    public void iClickLoginButton() {
        user.clicksLoginButton();
    }

    @Then("^I am on My Account page$")
    public void iAmOnMyAccountPage() {
        user.isOnMyAccountPage();
    }

    @And("^The header contains \"([^\"]*)\"$")
    public void theHeaderContains(String fullName) {
        user.seesHeaderWithText(fullName);
    }

    @Then("^I see \"([^\"]*)\" error message$")
    public void iSeeErrorMessage(String message) {
        user.seesErrorMessageWithText(message);
    }

}
