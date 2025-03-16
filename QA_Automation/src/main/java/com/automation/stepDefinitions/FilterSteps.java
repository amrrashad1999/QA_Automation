package com.automation.stepDefinitions;

import com.automation.pages.FilterPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class FilterSteps {
    WebDriver driver = new ChromeDriver();
    FilterPage filterPage = new FilterPage(driver);

    @When("User applies Free Shipping and New Condition filters")
    public void user_applies_free_shipping_and_new_condition_filters() {
        filterPage.applyFreeShippingFilter();
        filterPage.applyNewConditionFilter();
    }

    @Then("Verify filters are applied correctly")
    public void verify_filters_are_applied_correctly() {
        Assert.assertTrue(filterPage.areFiltersApplied());
    }
}
