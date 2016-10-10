package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://store.demoqa.com")
public class HomePage extends PageObject {

    @FindBy(css="input[name='s']")
    WebElementFacade searchField;

    public void searchFor(String keyword) {
        searchField.sendKeys(keyword, Keys.ENTER);
    }
}
