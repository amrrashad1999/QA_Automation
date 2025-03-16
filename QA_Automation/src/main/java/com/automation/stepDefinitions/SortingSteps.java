package com.automation.stepDefinitions;

import com.automation.pages.SortingPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class SortingSteps {
    WebDriver driver = new ChromeDriver();
    SortingPage sortingPage = new SortingPage(driver);

    @When("User sorts products by price high to low")
    public void user_sorts_products_by_price_high_to_low() {
        sortingPage.sortByPriceHighToLow();
    }

    @Then("Verify products are sorted correctly")
    public void verify_products_are_sorted_correctly() {
        Assert.assertTrue(sortingPage.isSortedByPriceHighToLow());
    }
}
