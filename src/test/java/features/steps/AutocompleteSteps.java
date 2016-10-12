package features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

public class AutocompleteSteps {
    @Steps
    UserSteps user;

    @Given("I am on the autocomplete page")
    public void iAmOnTheAutocompletePage() {
        user.opens_autocomplete_page();
    }

    @When("I insert '(.*)' into the input field")
    public void iInsertIntoTheInputField(String text) {
        user.inserts_into_the_input_field(text);
    }

    @And("I click the '(.*)' from the autocomplete list")
    public void iClickFromTheAutocompleteList(String value) {
        user.clicks_from_the_autocomplete_list(value);
    }

    @Then("I should see '(.*)' in the input field")
    public void iShouldSeeInTheInputField(String value) {
        user.should_see_in_the_input_field(value);
    }
}
