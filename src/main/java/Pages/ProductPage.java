package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriverWait wait;
    private By productName= By.xpath("//*[@id=\"tbodyid\"]/h2");
    private By addToCartBtn= By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private By productPrice= By.xpath("//*[@id=\"tbodyid\"]/h3");
    private By cartBtn= By.id("cartur");


    public String productNameItem(WebDriver driver){
        return driver.findElement(productName).getText();
    }
    public String productPriceItem(WebDriver driver){
        return driver.findElement(productPrice).getText();
    }
    public void clickOnAddToCart(WebDriver driver){
        driver.findElement(addToCartBtn).click();
    }
    public void handleAlert() throws InterruptedException {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        alert.accept();
    }
    public String popupMessage(WebDriver driver) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        return alert.getText();
    }
    public void clickOnCartPage(WebDriver driver){
        driver.findElement(cartBtn).click();
    }
}

