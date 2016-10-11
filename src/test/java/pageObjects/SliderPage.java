package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://demoqa.com/slider/")
public class SliderPage extends PageObject{

    @FindBy(css = "span[class*='ui-slider-handle']")
    WebElementFacade slider;

    @FindBy(css = "input[id='amount1']")
    WebElementFacade amount;

    public void slideBy(int offset) {
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(slider, offset, 0).perform();
    }

    public int getCurrentAmount() {
        return Integer.parseInt(amount.getAttribute("value"));
    }

}
