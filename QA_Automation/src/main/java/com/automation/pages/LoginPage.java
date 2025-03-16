package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    private By signInButton = By.id("nav-link-accountList-nav-line-1");
    private By emailField = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By loginButton = By.id("signInSubmit");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAmazon() {
        driver.get("https://www.amazon.eg/");
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void enterEmail() {
        driver.findElement(emailField).sendKeys("amr.rashad1999@gmail.com");
        driver.findElement(continueButton).click();
    }

    public void enterPassword() {
        driver.findElement(passwordField).sendKeys("12345678aA!#");
        driver.findElement(loginButton).click();
    }
}
