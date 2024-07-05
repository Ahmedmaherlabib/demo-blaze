package stepDefinition;

import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AddItemToCart {
    WebDriver driver=null;
    HomePage homePage;
    String userName;
    String password;
    ProductPage productPage;
    SoftAssert softAssert =new SoftAssert();

    @BeforeClass
    public void startUp() throws InterruptedException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage();
        productPage=new ProductPage();
        homePage.navigateToHomePage(driver);
        homePage.clickRegisterSignUpBtn(driver);
        LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        userName= "maher "+now.format(formatter);
        password=now.format(formatter);
        homePage.typeRegisterUserName(userName,driver);
        homePage.typeRegisterPassword(password,driver);
        homePage.clickSignUpBtn(driver);
        homePage.handleAlert();
        homePage.clickLoginBtn(driver);
        homePage.typeLoginUserName(userName,driver);
        homePage.typeLoginPassword(password,driver);
        homePage.clickLoginPopupBtn(driver);
        Thread.sleep(1000);

    }
    @Test
    public void addOneItemToCard() throws InterruptedException {

        String itemNameHomePage= homePage.productNameHomePage(driver);
        String itemHomePagePrice=homePage.productPriceHomePage(driver);
        Thread.sleep(1000);
        homePage.clickOnSamsungMobileItem(driver);
        Thread.sleep(2000);
        String itemName= productPage.productNameItem(driver);
        String itemPrice= productPage.productPriceItem(driver);
        Assert.assertTrue(itemPrice.contains(itemHomePagePrice));
        Assert.assertEquals(itemNameHomePage,itemName);
        productPage.clickOnAddToCart(driver);
        softAssert.assertEquals(productPage.popupMessage(driver),"Product added.");
        productPage.handleAlert();
        softAssert.assertAll();


    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
