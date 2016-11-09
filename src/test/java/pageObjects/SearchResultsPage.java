package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by testuser on 08/11/16.
 */
public class SearchResultsPage extends PageObject {

    private String title = "Search Results";

    @FindBy(css = "a.go-right")
    public List<WebElementFacade> resultsCities;

    @FindBy(xpath = "//small[contains(text(), 'Total Stay')]/following-sibling::span")
    public WebElementFacade totalStay;

    public boolean isDisplayed() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForTitle(title);

        return getTitle().equals(title);
    }

    public boolean areAllHotelsFrom(String city) {

        for (WebElementFacade element : resultsCities) {
            getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
            if (!element.getText().equals(city))
                return false;
        }

        return true;
    }
}
