package features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

public class DroppableSteps {

    @Steps
    UserSteps user;

    @Given("I am on the Droppable page")
    public void iAmOnTheDroppablePage() {
        user.opens_droppable_page();
    }

    @When("I drag and drop element into the area")
    public void iDragAndDropElementIntoTheArea() {
        user.dragAndDrops_element_into_the_area();
    }

    @Then("I should see '(.*)' as the title of the area")
    public void iShouldSeeAsTheTitleOfTheArea(String title) {
        user.should_see_the_title_of_the_area_as(title);
    }
}
