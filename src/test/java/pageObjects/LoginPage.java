package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by testuser on 04/11/16.
 */
public class LoginPage extends PageObject {
    private String title = "Login";

    @FindBy(css = "input[name='username']")
    WebElementFacade usernameField;

    @FindBy(css = "input[name='password']")
    WebElementFacade passwordField;

    @FindBy(css = "button[class*='loginbtn']")
    WebElementFacade loginButton;

    @FindBy(css = "div[class='alert alert-danger']")
    WebElementFacade errorMessage;


    public boolean isDisplayed() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForTitle(title);

        return getTitle().equals(title);
    }

    public void insertIntoUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void insertIntoPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return withTimeoutOf(60, TimeUnit.SECONDS).waitFor(errorMessage).getText();
    }
}
