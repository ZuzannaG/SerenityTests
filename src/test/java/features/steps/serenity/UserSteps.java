package features.steps.serenity;

import net.thucydides.core.annotations.Step;
import pageObjects.*;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by testuser on 07/10/16.
 */
public class UserSteps {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchResultsPage searchResultsPage;

    @Step
    public void opensHomePage() {
        homePage.open();
    }

    @Step
    public void clicksMyAccount() {
        homePage.myAccountButton.click();
    }

    @Step
    public void clicksLogin() {
        homePage.loginButton.click();
    }

    @Step
    public void isOnLoginPage() {
        assertTrue(loginPage.isDisplayed());
    }

    @Step
    public void entersUsername(String username) {
        loginPage.usernameField.sendKeys(username);
    }

    @Step
    public void entersPassword(String password) {
        loginPage.passwordField.sendKeys(password);
    }

    @Step
    public void clicksLoginButton() {
        loginPage.loginButton.click();
    }

    @Step
    public void isOnMyAccountPage() {
        assertTrue(myAccountPage.isDisplayed());
    }

    @Step
    public void seesHeaderWithText(String text) {
        assertTrue(myAccountPage.getHeaderText().contains(text));
    }

    @Step
    public void seesErrorMessageWithText(String text) {
        assertEquals(text, loginPage.getErrorMessage());
    }

    @Step
    public void clicksOnTheTab(String tabName) {
        switch (tabName) {
            case "Hotels":
                homePage.hotelsTab.click();
                break;
            case "Flights":
                homePage.flightsTab.click();
                break;
            case "Tours":
                homePage.toursTab.click();
                break;
            case "Cars":
                homePage.carsTab.click();
                break;
            default:
                throw new IllegalArgumentException("Tab name is incorrect");
        }
    }

    @Step
    public void insertsIntoTheCitySearchField(String city) {
        homePage.insertIntoSearchField(0, city);
    }

    @Step
    public void selectsTheOptionFromTheList(int index) {
        homePage.selectFromTheCityNamesList(index - 1);
    }

    @Step
    public void selectsAsTheStartDay(Calendar date) {
        homePage.selectStartDate(date);
    }

    @Step
    public void selectsAsTheEndDay(Calendar date) {
        homePage.selectEndDate(date);
    }

    @Step
    public void selectsAdults(int number) {
        homePage.selectAdults(number);
    }

    @Step
    public void selectsChildren(int number) {
        homePage.selectChildren(number);
    }

    @Step
    public void clicksSearch() {
        homePage.searchButton.click();
    }

    @Step
    public void isOnSearchResultsPage() {
        assertTrue(searchResultsPage.isDisplayed());
    }

    @Step
    public void seesOnlyResultsFrom(String city) {
        assertTrue(searchResultsPage.areAllResultsFrom(city));
    }

    @Step
    public void seesThatTotalStayIs(String totalStay) {
        assertTrue(searchResultsPage.totalStay.getText().equals(totalStay));
    }

    @Step
    public void selectsTourType(String type) {
        homePage.selectTourType(type);
    }

    @Step
    public void seesOnlyResultsWithType(String type) {
        assertTrue(searchResultsPage.areAllResultsWithType(type));
    }

    @Step
    public void selectsTime(int dropdownId, String time) {
        homePage.selectTime(dropdownId, time);
    }

    @Step
    public void insertsIntoThePickupLocation(String city) {
        homePage.insertIntoLocation(0, city);
    }

    @Step
    public void selectsAsTheCheckInDate(Calendar date) {
        homePage.selectDate(0, date);
    }

    @Step
    public void selectsAsTheCheckOutDate(Calendar date) {
        homePage.selectDate(1, date);
    }

    @Step
    public void seesThatSelectedLocationIs(String city) {
        assertTrue(homePage.isSelectedLocationEqual(city));
    }
}
