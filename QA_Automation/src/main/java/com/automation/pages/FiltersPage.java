package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiltersPage {
    WebDriver driver;

    private By freeShippingFilter = By.xpath("//span[text()='Free Shipping']");
    private By newConditionFilter = By.xpath("//span[text()='New']");

    public FiltersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFreeShipping() {
        driver.findElement(freeShippingFilter).click();
    }

    public void applyNewCondition() {
        driver.findElement(newConditionFilter).click();
    }
}

