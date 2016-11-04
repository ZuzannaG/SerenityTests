package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by testuser on 04/11/16.
 */
public class MyAccountPage extends PageObject {
    private String title = "My Account";

    @FindBy(css = "h3.RTL")
    WebElementFacade header;

    public boolean isDisplayed() {
        return new WebDriverWait(getDriver(), 60).until(ExpectedConditions.titleIs(title));
    }

    public String getHeaderText() {
        return header.getText();
    }
}
