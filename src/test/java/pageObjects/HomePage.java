package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://phptravels.net")
public class HomePage extends PageObject {

    @FindBy(css = "li.pull-right > a.dropdown-toggle")
    public WebElementFacade myAccountButton;

    @FindBy(css = "a[href*='login']")
    public WebElementFacade loginButton;

    @FindBy(css = "div.active input.searchInput")
    public List<WebElementFacade> searchInputs;

    @FindBy(css = "div.active div.days > span")
    public List<WebElementFacade> dates;

    @FindBy(css = "div.active div.chkin")
    public WebElementFacade startDate;

    @FindBy(css = "div.active div.chkout")
    public WebElementFacade endDate;

    @FindBy(css = "div.active input#adults ~ div.inc:not(.minusplus)")
    public WebElementFacade adultsPlusButton;

    @FindBy(css = "div.active input#child ~ div.inc:not(.minusplus)")
    public WebElementFacade childPlusButton;

    @FindBy(css = "div.active button.btn-primary")
    public WebElementFacade searchButton;

    @FindBy(css = "div.active ul.dropdown-menu li")
    public List<WebElementFacade> cityNamesList;

    @FindBy(css = "span.hotel")
    public WebElementFacade hotelsTab;

    @FindBy(css = "span.flight")
    public WebElementFacade flightsTab;

    @FindBy(css = "span.suitcase")
    public WebElementFacade toursTab;

    @FindBy(css = "span.car")
    public WebElementFacade carsTab;

    @FindBy(css = "div.dropdown-menu[style*='display: block;'] td.day:not(.disabled)")
    public List<WebElementFacade> days;

    @FindBy(css = "div.active input#adults")
    public WebElementFacade currentAdults;

    @FindBy(css = "div.active input#child")
    public WebElementFacade currentChildren;

    @FindBy(css = "select#tourtype")
    public WebElementFacade tourTypes;

    @FindBy(css = "div.active select.selectx")
    public List<WebElementFacade> times;

    @FindBy(css = "a.select2-choice")
    public List<WebElementFacade> carLocations;

    @FindBy(css = "span.select2-chosen")
    public WebElementFacade selectedLocation;

    public void insertIntoSearchField(int searchId, String value) {
        searchInputs.get(searchId).sendKeys(value);
    }

    public void selectFromTheCityNamesList(int index) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(cityNamesList);
        cityNamesList.get(index).click();
    }

    public void selectDate(int calendarIndex, Calendar date) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(dates);
        dates.get(calendarIndex).click();
        clickOnDay(date);
    }

    public void selectStartDate(Calendar date) {
        startDate.click();
        clickOnDay(date);
    }

    public void selectEndDate(Calendar date) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(endDate).click();
        clickOnDay(date);
    }

    public void clickOnDay(Calendar date) {
        String day = Integer.toString(date.get(Calendar.DAY_OF_MONTH));

        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(days);

        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().equals(day)) {
                days.get(i).click();
                break;
            }
        }
    }

    public void selectAdults(int number) {
        while (Integer.valueOf(currentAdults.getValue()) < number)
            adultsPlusButton.click();
    }

    public void selectChildren(int number) {
        while (Integer.valueOf(currentChildren.getValue()) < number)
            childPlusButton.click();
    }

    public void selectTourType(String type) {
        Select tourTypesDropdown = new Select(tourTypes);
        tourTypesDropdown.selectByVisibleText(type);
    }

    public void selectTime(int dropdownId, String time) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(times);
        Select timeDropdown = new Select(times.get(dropdownId));
        timeDropdown.selectByVisibleText(time);
    }

    public void insertIntoLocation(int fieldId, String city) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(carLocations);
        carLocations.get(fieldId).click();
        carLocations.get(fieldId).sendKeys(city);
        carLocations.get(fieldId).sendKeys(Keys.ENTER);
    }

    public boolean isSelectedLocationEqual(String city) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitForText(selectedLocation, city);

        return selectedLocation.getText().equals(city);
    }
}
