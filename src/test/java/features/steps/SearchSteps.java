package features.steps;

import cucumber.api.PendingException;
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

    @And("^I select the (\\d+) option from the list$")
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

    @And("^I can see only results from \"([^\"]*)\"$")
    public void iCanSeeOnlyHotelsIn(String city) {
        user.seesOnlyResultsFrom(city);
    }

    @And("^I can see that Total Stay is \"([^\"]*)\"$")
    public void iCanSeeThatTotalStayIs(String totalStay) {
        user.seesThatTotalStayIs(totalStay);
    }

    @And("^I select \"([^\"]*)\" as the tour type$")
    public void iSelectAsTheTourType(String type) {
        user.selectsTourType(type);
    }

    @And("^I can only see results with type \"([^\"]*)\"$")
    public void iCanOnlySeeResultsWithType(String type) {
        user.seesOnlyResultsWithType(type);
    }

    @And("^I select \"([^\"]*)\" as the pickup time$")
    public void iSelectAsThePickupTime(String time) {
        user.selectsTime(0, time);
    }

    @And("^I select \"([^\"]*)\" as the drop off time$")
    public void iSelectAsTheDropOffTime(String time) {
        user.selectsTime(1, time);
    }

    @When("^I insert \"([^\"]*)\" into the pickup location$")
    public void iInsertIntoThePickupLocation(String city) {
        user.insertsIntoThePickupLocation(city);
    }

    @And("^I select tomorrow as the check in date$")
    public void iSelectTomorrowAsTheCheckInDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, 1);
        user.selectsAsTheCheckInDate(date);
    }

    @And("^I select day after tomorrow as the checkout date$")
    public void iSelectDayAfterTomorrowAsTheCheckoutDate() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, 2);
        user.selectsAsTheCheckOutDate(date);
    }

    @Then("^Selected location is \"([^\"]*)\"$")
    public void selectedLocationIs(String city) {
        user.seesThatSelectedLocationIs(city);
    }
}
