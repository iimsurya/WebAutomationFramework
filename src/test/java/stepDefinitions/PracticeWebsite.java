package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AutomationPracticeSectionOne;
import pages.AutomationPracticeSectionTwo;

public class PracticeWebsite {

    AutomationPracticeSectionOne automationPracticeSectionOne = new AutomationPracticeSectionOne();
    AutomationPracticeSectionTwo automationPracticeSectionTwo = new AutomationPracticeSectionTwo();
    @Given("User is landed in Automation practice web application")
    public void user_is_landed_in_automation_practice_web_application() {
        automationPracticeSectionOne.openPracticeWebsite();
    }
    @When("User selects {string} radio button")
    public void user_selects_radio_button(String string) {
        automationPracticeSectionOne.selectRadioButton();
    }
    @When("User searches country with first three char of {string} and selects county from suggestion")
    public void user_searches_country_with_first_three_char_of_and_selects_county_from_suggestion(String string) {
        automationPracticeSectionOne.chooseCountry();
    }
    @When("User selects {string} in dropdown example")
    public void user_selects_in_dropdown_example(String string) {
        automationPracticeSectionOne.selectOptionFromDropdown();
    }
    @When("User clicks {string} in checkbox example")
    public void user_clicks_in_checkbox_example(String string) {
        automationPracticeSectionOne.selectCheckBox();
    }
    @Then("User verifies all the selected details in screen")
    public void user_verifies_all_the_selected_details_in_screen() {
        try {
            automationPracticeSectionOne.quitBrowser();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User clicks {string} button and switch to new window")
    public void userClicksButtonAndSwitchToNewWindow(String arg0) {
        try {
            automationPracticeSectionTwo.switchWindow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
