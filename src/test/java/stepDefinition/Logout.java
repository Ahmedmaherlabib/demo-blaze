package stepDefinition;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver driver=null;
    HomePage homePage;
    String userName;
    String password;
    ProductPage productPage;
    CartPage cartPage;
    SoftAssert softAssert =new SoftAssert();
    @BeforeClass
    public void startUp() throws InterruptedException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        homePage.navigateToHomePage(driver);
        homePage.clickRegisterSignUpBtn(driver);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        userName = "maher " + now.format(formatter);
        password = now.format(formatter);
        homePage.typeRegisterUserName(userName, driver);
        homePage.typeRegisterPassword(password, driver);
        homePage.clickSignUpBtn(driver);
        homePage.handleAlert();
        homePage.clickLoginBtn(driver);
        homePage.typeLoginUserName(userName, driver);
        homePage.typeLoginPassword(password, driver);
        homePage.clickLoginPopupBtn(driver);
        Thread.sleep(2000);
    }
    @Test
    public void clickLogoutBtn() throws InterruptedException {
        Thread.sleep(3000);
        homePage.clickLogoutBtn(driver);
        Thread.sleep(3000);

    }
    @AfterClass
      public void closeBrowser(){
        driver.quit();
    }
}
