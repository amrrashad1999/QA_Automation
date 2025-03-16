package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCheckoutPage {
    WebDriver driver;

    public AmazonCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAddress() {
        driver.findElement(By.id("enterAddressFullName")).sendKeys("Amr Rashad");
        driver.findElement(By.id("enterAddressAddressLine1")).sendKeys("Cairo, Egypt");
        driver.findElement(By.id("enterAddressCity")).sendKeys("Cairo");
        driver.findElement(By.id("enterAddressPostalCode")).sendKeys("11111");
        driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys("01012345678");
        driver.findElement(By.id("shipToThisAddressButton")).click();
    }

    public void selectPaymentMethod(String method) {
        driver.findElement(By.xpath("//span[text()='" + method + "']")).click();
    }

    public void verifyTotalAmount() {
        String totalPrice = driver.findElement(By.id("total-price")).getText();
        System.out.println("Total price including shipping: " + totalPrice);
    }
}
