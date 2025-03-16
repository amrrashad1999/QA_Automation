package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class AmazonProductPage {
    WebDriver driver;

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilters(String filter1, String filter2) {
        driver.findElement(By.xpath("//span[text()='" + filter1 + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + filter2 + "']")).click();
    }

    public void sortProducts(String sortingOption) {
        driver.findElement(By.id("s-result-sort-select")).click();
        driver.findElement(By.xpath("//option[text()='" + sortingOption + "']")).click();
    }

    public void addProductsBelowPrice(int maxPrice) {
        List<WebElement> products = driver.findElements(By.cssSelector(".s-price"));
        for (WebElement product : products) {
            String priceText = product.getText().replace("EGP", "").trim();
            int price = Integer.parseInt(priceText.replace(",", ""));
            if (price < maxPrice) {
                product.click();
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.navigate().back();
            }
        }
    }
}
