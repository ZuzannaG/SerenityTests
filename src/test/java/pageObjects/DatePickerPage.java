package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@DefaultUrl("http://demoqa.com/datepicker/")
public class DatePickerPage extends PageObject {

    @FindBy(css = "input[id = 'datepicker1']")
    WebElementFacade dateInput;

    @FindBy(css = "table[class = 'ui-datepicker-calendar']")
    WebElementFacade calendar;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-handler]/a")
    List<WebElementFacade> allDays;

    public void select(int day) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(calendar));

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
        dateInput.click();
    }

    public String getDateFromInput() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dateInput, "value"));

        return dateInput.getAttribute("value");
    }
}
