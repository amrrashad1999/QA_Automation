package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CartPage {
    WebDriver driver;

    private By productPrices = By.xpath("//span[@class='a-price-whole']");
    private By addToCartButtons = By.xpath("//input[@value='Add to Cart']");
    private By nextPage = By.xpath("//a[text()='Next']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductsBelow15K() {
        List<WebElement> prices = driver.findElements(productPrices);
        List<WebElement> buttons = driver.findElements(addToCartButtons);

        for (int i = 0; i < prices.size(); i++) {
            int price = Integer.parseInt(prices.get(i).getText().replace(",", ""));
            if (price < 15000) {
                buttons.get(i).click();
            }
        }
    }

    public void goToNextPage() {
        driver.findElement(nextPage).click();
    }
}
