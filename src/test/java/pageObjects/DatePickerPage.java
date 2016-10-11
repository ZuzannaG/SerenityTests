package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://demoqa.com/datepicker/")
public class DatePickerPage extends PageObject {

    @FindBy(css = "input[id = 'datepicker1']")
    WebElementFacade dateInput;

    @FindBy(css = "table[class = 'ui-datepicker-calendar']")
    WebElementFacade calendar;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-handler]/a")
    List<WebElementFacade> allDays;

    public void select(int day) {

        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(calendar));

        for(WebElementFacade element:allDays) {
            int dayValue = Integer.parseInt(element.getText());

            if(dayValue == day) {
                element.click();
                break;
            }
        }
    }

    public void clickDateInput() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(dateInput));
        dateInput.click();
    }

    public String getDateFromInput() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.attributeToBeNotEmpty(dateInput, "value"));

        return dateInput.getAttribute("value");
    }
}
