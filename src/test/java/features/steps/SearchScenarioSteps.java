package features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.BuyerSteps;
import net.thucydides.core.annotations.Steps;


public class SearchScenarioSteps {
    @Steps
    BuyerSteps buyer;

    @Given("I open the homepage")
    public void iOpenTheHomepage() {
        buyer.opens_home_page();
    }

    @When("I search for '(.*)'")
    public void iSearchFor(String keyword) {
        buyer.searches_for_keyword(keyword);
    }

    @Then("I should see only articles related to '(.*)'")
    public void iShouldSeeOnlyArticlesRelatedTo(String keyword) {
        buyer.should_see_results_summary_containing(keyword);
    }
}
