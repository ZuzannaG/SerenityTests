package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://demoqa.com/droppable/")
public class DroppablePage extends PageObject {

    @FindBy(css = "div[id = 'draggableview']")
    WebElementFacade draggableElement;

    @FindBy(css = "div[id = 'droppableview']")
    WebElementFacade droppableArea;

    @FindBy(css = "div[id = 'droppableview'] > p")
    WebElementFacade droppableAreaTitle;

    public void dragAndDropElementIntoArea() {
        Actions action = new Actions(getDriver());
        action.dragAndDrop(draggableElement, droppableArea).perform();
    }

    public String getTheTitleOfDroppableArea() {
        return droppableAreaTitle.getText();
    }
}
