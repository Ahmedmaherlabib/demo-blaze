package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriverWait wait;
    private  By signUpHomePageBtn= By.id("signin2");
    private  By loginHomePageBtn= By.id("login2");
    private  By userNameField= By.id("sign-username");
    private  By userNameLogin= By.id("loginusername");
    private  By passwordField= By.id("sign-password");
    private  By passwordLogin= By.id("loginpassword");
    private  By signUpBtn= By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    private  By closeBtn= By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
    private  By loginBtn= By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private  By samsungMobileGalaxyS6 =By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a");
    private  By samsungMobileGalaxyS6Price =By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h5");
    private  By userEmailAccount =By.id("nameofuser");
    private  By logoutBtn= By.id("logout2");
    public void navigateToHomePage(WebDriver driver){
        driver.navigate().to("https://www.demoblaze.com/");
    }
    public void clickRegisterSignUpBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(signUpHomePageBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));}
    public void typeRegisterUserName(String user, WebDriver driver){driver.findElement(userNameField).sendKeys(user);}
    public void typeRegisterPassword(String password,WebDriver driver){driver.findElement(passwordField).sendKeys(password);}
    public void clickSignUpBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(signUpBtn).click();
    }
    public String checkNameOfUser(WebDriver driver){
        return driver.findElement(userEmailAccount).getText();
    }
    public void handleAlert() throws InterruptedException {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        alert.accept();
    }
    public String popupMessage(WebDriver driver) throws InterruptedException {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);
        return alert.getText();
    }
    public void closeSignUpPopup(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(closeBtn).click();
        Thread.sleep(1000);
    }
    public void typeLoginUserName(String user,WebDriver driver){
        driver.findElement(userNameLogin).sendKeys(user);
    }
    public void typeLoginPassword(String password,WebDriver driver){
        driver.findElement(passwordLogin).sendKeys(password);}
    public void clickOnSamsungMobileItem(WebDriver driver){
        driver.findElement(samsungMobileGalaxyS6).click();
    }

    public void clickLoginBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(loginHomePageBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }
    public void clickLoginPopupBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(loginBtn).click();
        }
        public String productNameHomePage(WebDriver driver){
        return driver.findElement(samsungMobileGalaxyS6).getText();
        }
    public String productPriceHomePage(WebDriver driver){
        return driver.findElement(samsungMobileGalaxyS6Price).getText();
    }
    public void clickLogoutBtn(WebDriver driver){
        driver.findElement(logoutBtn).click();
    }


}
