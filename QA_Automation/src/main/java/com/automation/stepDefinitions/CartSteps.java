package com.automation.stepDefinitions;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartSteps {
    WebDriver driver = new ChromeDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("Verify all selected products are added to the cart")
    public void verify_all_selected_products_are_added_to_the_cart() {
        Assert.assertTrue(cartPage.areProductsInCart());
    }

    @Then("Ensure total price matches expected price including shipping")
    public void ensure_total_price_matches_expected_price_including_shipping() {
        double expectedTotal = cartPage.calculateExpectedTotal();
        double actualTotal = cartPage.getCartTotal();
        Assert.assertEquals(expectedTotal, actualTotal, 0.1);
        driver.quit();
    }
}
