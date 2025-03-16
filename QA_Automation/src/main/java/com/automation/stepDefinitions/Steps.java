package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*; // Importing Page Classes

public class Steps {
    WebDriver driver;
    AmazonLoginPage loginPage;
    AmazonHomePage homePage;
    AmazonProductPage productPage;
    AmazonCartPage cartPage;
    AmazonCheckoutPage checkoutPage;

    @Given("I open Amazon website")
    public void openAmazon() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.eg/");
    }

    @When("I log in with {string} and {string}")
    public void login(String email, String password) {
        loginPage = new AmazonLoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @And("I navigate to {string} > {string} > {string}")
    public void navigateToCategory(String mainCategory, String subCategory, String specificCategory) {
        homePage = new AmazonHomePage(driver);
        homePage.navigateToCategory(mainCategory, subCategory, specificCategory);
    }

    @And("I apply filters {string} and {string}")
    public void applyFilters(String filter1, String filter2) {
        productPage = new AmazonProductPage(driver);
        productPage.applyFilters(filter1, filter2);
    }

    @And("I sort by {string}")
    public void sortBy(String sortingOption) {
        productPage.sortProducts(sortingOption);
    }

    @And("I add all products below 15K EGP to cart")
    public void addProductsToCart() {
        productPage.addProductsBelowPrice(15000);
    }

    @Then("I verify all products are in the cart")
    public void verifyCartContents() {
        cartPage = new AmazonCartPage(driver);
        cartPage.verifyCartItems();
    }

    @And("I add address and select cash as payment")
    public void addAddressAndPayment() {
        checkoutPage = new AmazonCheckoutPage(driver);
        checkoutPage.enterAddress();
        checkoutPage.selectPaymentMethod("Cash");
    }

    @Then("I verify total price with shipping cost")
    public void verifyTotalPrice() {
        checkoutPage.verifyTotalAmount();
    }
}
