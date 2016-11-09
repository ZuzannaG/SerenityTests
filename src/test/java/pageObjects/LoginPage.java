package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by testuser on 04/11/16.
 */
public class LoginPage extends PageObject {
    private String title = "Login";

    @FindBy(css = "input[name='username']")
    public WebElementFacade usernameField;

    @FindBy(css = "input[name='password']")
    public WebElementFacade passwordField;

    @FindBy(css = "button[class*='loginbtn']")
    public WebElementFacade loginButton;

    @FindBy(css = "div[class='alert alert-danger']")
    public WebElementFacade errorMessage;

    public boolean isDisplayed() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForTitle(title);

        return getTitle().equals(title);
    }

    public String getErrorMessage() {
        return withTimeoutOf(60, TimeUnit.SECONDS).waitFor(errorMessage).getText();
    }
}
