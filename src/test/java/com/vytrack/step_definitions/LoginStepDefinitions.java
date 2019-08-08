package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {

    Pages pages = new Pages();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        pages.loginPage().goToLandingPage();
    }

    @Then("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        pages.loginPage().login(ConfigurationReader.getProperty("storemanagerusername"),
                                ConfigurationReader.getProperty("storemanagerpassword"));
    }


    @Then("user verifies that {string} page name is displayed")
    public void user_verifies_that_page_name_is_displayed(String string) {
       Assert.assertEquals(string, pages.dashboardPage().getPageSubTitle());
    }

    @Then("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        pages.loginPage().login(string, string2);
    }

    @Then("user verifies that {string} warning message is displayed")
    public void user_verifies_that_warning_message_is_displayed(String string) { //string can be defined
        Assert.assertEquals(string, pages.loginPage().getErrorMessage());
    }

    @Then("user quits")
    public void user_quits() {
        Driver.closeDriver();
    }


}
