package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@DefaultUrl("http://demoqa.com/datepicker/")
public class DatePickerPage extends PageObject {

    @FindBy(css = "input[id = 'datepicker1']")
    WebElementFacade dateInput;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-handler]/a")
    List<WebElementFacade> allDays;

    public void select(int day) {

        for(WebElementFacade element:allDays) {
            int dayValue = Integer.parseInt(element.getText());

            if(dayValue == day) {
                element.click();
                break;
            }
        }
    }

    public void clickDateInput() {
        dateInput.click();
    }

    public String getDateFromInput() {
        waitFor(ExpectedConditions.attributeToBeNotEmpty(dateInput, "value"));

        return dateInput.getAttribute("value");
    }
}
