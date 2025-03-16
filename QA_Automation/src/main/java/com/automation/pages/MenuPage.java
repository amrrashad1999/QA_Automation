package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;

    private By allMenu = By.id("nav-hamburger-menu");
    private By videoGames = By.xpath("//a[text()='Video Games']");
    private By allVideoGames = By.xpath("//a[text()='All Video Games']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAllMenu() {
        driver.findElement(allMenu).click();
    }

    public void selectVideoGames() {
        driver.findElement(videoGames).click();
    }

    public void selectAllVideoGames() {
        driver.findElement(allVideoGames).click();
    }
}
