package features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by testuser on 10/10/16.
 */
public class SelectableSteps {

    @Steps
    UserSteps userSteps;

    @Given("I am on the Selectable page")
    public void iAmOnTheSelectablePage() {
        userSteps.opens_selectable_page();
    }

    @When("I select '(.*)'")
    public void iSelectItem(String item)  {
        userSteps.selects(item);
    }

    @Then("'(.*)' is selected")
    public void itemIsSelected(String item) {
        userSteps.should_see_selected(item);
    }
}
