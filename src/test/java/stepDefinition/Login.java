package stepDefinition;

import org.testng.Assert;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver=null;
    HomePage homePage;
    String userName;
    String password;
    SignUp signUp;
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void startUp() throws InterruptedException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            homePage = new HomePage();
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
            Thread.sleep(1000);

        }
    @Test(priority = 1)
    public void loginWithEmptyDate() throws InterruptedException {
        homePage.navigateToHomePage(driver);
        homePage.clickLoginBtn(driver);
        homePage.clickLoginPopupBtn(driver);
        softAssert.assertEquals(homePage.popupMessage(driver),"Please fill out Username and Password.");
        homePage.handleAlert();
        softAssert.assertAll();
    }

        @Test(priority = 2)
        public void loginWithInvalidDate() throws InterruptedException {
        homePage.navigateToHomePage(driver);
        homePage.clickLoginBtn(driver);
        homePage.typeLoginUserName("wrong data",driver);
        homePage.typeLoginPassword("wrong data",driver);
        homePage.clickLoginPopupBtn(driver);
        softAssert.assertEquals(homePage.popupMessage(driver),"User does not exist.");
        homePage.handleAlert();
        softAssert.assertAll();

        }
    @Test(priority = 3)
    public void loginWithWrongPassword() throws InterruptedException {
        homePage.navigateToHomePage(driver);
        homePage.clickLoginBtn(driver);
        homePage.typeLoginUserName(userName, driver);
        homePage.typeLoginPassword("wrong data", driver);
        homePage.clickLoginPopupBtn(driver);
        softAssert.assertEquals(homePage.popupMessage(driver), "Wrong password.");
        homePage.handleAlert();
        softAssert.assertAll();
    }

        @Test(priority = 4)
    public void loginSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        homePage.navigateToHomePage(driver);
        homePage.clickLoginBtn(driver);
        homePage.typeLoginUserName(userName,driver);
        homePage.typeLoginPassword(password,driver);
        homePage.clickLoginPopupBtn(driver);
        Thread.sleep(2000);
        Assert.assertTrue(homePage.checkNameOfUser(driver).contains(userName));


    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}

