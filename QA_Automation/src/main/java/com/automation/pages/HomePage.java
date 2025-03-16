package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonHomePage {
    WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCategory(String mainCategory, String subCategory, String specificCategory) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText(mainCategory))).perform();
        driver.findElement(By.linkText(subCategory)).click();
        driver.findElement(By.linkText(specificCategory)).click();
    }
}
