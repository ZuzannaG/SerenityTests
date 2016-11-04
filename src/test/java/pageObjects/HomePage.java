package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://phptravels.net")
public class HomePage extends PageObject {

    @FindBy(css="li.pull-right > a.dropdown-toggle")
    WebElementFacade myAccountButton;

    @FindBy(css="a[href*='login']")
    WebElementFacade loginButton;

    public void clickMyAccount() {
        myAccountButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }

}
