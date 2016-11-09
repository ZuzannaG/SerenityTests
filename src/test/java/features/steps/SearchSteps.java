package features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;
import java.util.Calendar;

/**
 * Created by testuser on 08/11/16.
 */
public class SearchSteps {

    @Steps
    UserSteps user;

    @Given("I am on the \"(.*)\" tab")
    public void iAmOnTheTab(String tabName) {
        user.clicksOnTheTab(tabName);
    }

    @When("^I insert \"([^\"]*)\" into the city search field$")
    public void iInsertIntoTheCitySearchField(String city) {
        user.insertsIntoTheCitySearchField(city);
    }

    @And("^I select the (\\d+)st option from the list$")
    public void iSelectTheStOptionFromTheList(int index) {
        user.selectsTheOptionFromTheList(index);
    }

    @And("^I select tomorrow as the start date$")
    public void iSelectTomorrowAsTheStartDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, 1);
        user.selectsAsTheStartDay(date);
    }

    @And("^I select day after tomorrow as the end date$")
    public void iSelectDayAfterTomorrowAsTheEndDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, 2);
        user.selectsAsTheEndDay(date);
    }

    @And("^I select (\\d+) adults$")
    public void iSelectAdults(int number) {
        user.selectsAdults(number);
    }

    @And("^I select (\\d+) children$")
    public void iSelectChildren(int number) {
        user.selectsChildren(number);
    }

    @And("^I click Search$")
    public void iClickSearch() {
        user.clicksSearch();
    }

    @Then("^I am on the Search Results page$")
    public void iAmOnTheSearchResultsPage() {
        user.isOnSearchResultsPage();
    }

    @And("^I can see only hotels in \"([^\"]*)\"$")
    public void iCanSeeOnlyHotelsIn(String city) {
        user.seesOnlyHotelsIn(city);
    }

    @And("^I can see that Total Stay is \"([^\"]*)\"$")
    public void iCanSeeThatTotalStayIs(String totalStay) {
        user.seesThatTotalStayIs(totalStay);
    }
}
