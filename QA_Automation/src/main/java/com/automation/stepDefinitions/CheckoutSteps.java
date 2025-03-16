package com.automation.stepDefinitions;

import com.automation.pages.CheckoutPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutSteps {
    WebDriver driver = new ChromeDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("User enters address and selects cash on delivery")
    public void user_enters_address_and_selects_cash_on_delivery() {
        checkoutPage.enterAddress();
        checkoutPage.selectCashPayment();
    }

    @Then("Verify order is not completed")
    public void verify_order_is_not_completed() {
        checkoutPage.verifyOrderNotPlaced();
        driver.quit();
    }
}
