package com.automation.stepDefinitions;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();  // Use the shared WebDriver from Hooks
        loginPage = new LoginPage(driver);
    }

    @Given("User navigates to Amazon Egypt login page")
    public void user_navigates_to_amazon_egypt_login_page() {
        driver.get("https://www.amazon.eg/");
        driver.manage().window().maximize();
    }

    @When("User logs in with email {string} and password {string}")
    public void user_logs_in_with_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue("Login was not successful!", loginPage.isLoggedIn());
    }
}
