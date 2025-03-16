package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SortingPage {
    WebDriver driver;

    private By sortDropdown = By.id("s-result-sort-select");

    public SortingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByHighToLow() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText("Price: High to Low");
    }
}
