package features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

public class SliderSteps {
@Steps
    UserSteps user;

    @Given("I open the Slider page")
    public void iOpenTheSliderPage() {
        user.opens_slider_page();
    }

    @When("I slide the slider by (.*)")
    public void iSlideTheSliderBy(int offset) {
        user.slides_the_slider_by(offset);
    }

    @Then("The displayed amount is equal to (.*)")
    public void theDisplayedAmountIsEqualTo(int amount) {
        user.should_see_the_amount(amount);
    }
}
