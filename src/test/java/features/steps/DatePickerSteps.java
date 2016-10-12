package features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

public class DatePickerSteps {
    @Steps
    UserSteps user;

    @Given("I am on the DatePicker page")
    public void iAmOnTheDatePickerPage() {
        user.opens_datepicker_page();
    }

    @When("I click on the date input")
    public void iClickOnTheDateInput() {
        user.clicks_on_the_date_input();
    }


    @And("I select (.*)th day of the current month")
    public void iSelectDayOfTheCurrentMonth(int day) {
        user.selects(day);
    }


    @Then("The (.*)th day of the current month should be in the date input")
    public void theDayOfTheCurrentMonthShouldBeInTheDateInput(int day) {
        user.should_see_in_the_date_input(day);
    }
}
