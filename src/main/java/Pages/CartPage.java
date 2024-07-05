package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By productName = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");
    private By productPrice = By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]");
    private By placeOrderBtn = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By creditCard = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By PurchaseBtn = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By closeBtn = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    private By OKBtn= By.xpath("/html/body/div[10]/div[7]/div/button");

public void clickOnPlaceOrderBtn(WebDriver driver){
    driver.findElement(placeOrderBtn).click();
}
public void fillPaymentForm(WebDriver driver) throws InterruptedException {
    driver.findElement(name).sendKeys("test");
    driver.findElement(country).sendKeys("test");
    driver.findElement(city).sendKeys("test");
    driver.findElement(creditCard).sendKeys("424242424242");
    driver.findElement(month).sendKeys("5");
    driver.findElement(year).sendKeys("2028");
    driver.findElement(PurchaseBtn).click();
    Thread.sleep(2000);
    driver.findElement(OKBtn).click();
    Thread.sleep(3000);

}






}
