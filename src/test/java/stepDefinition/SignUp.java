package stepDefinition;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class SignUp {
    WebDriver driver=null;
    HomePage homePage;
    String userName;
    String password;
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
        public void startUp(){
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            homePage = new HomePage();
    }
    @Test(priority = 1)
    public void emptyInputs() throws InterruptedException {
     homePage.navigateToHomePage(driver);
     homePage.clickRegisterSignUpBtn(driver);
     homePage.clickSignUpBtn(driver);
     softAssert.assertEquals(homePage.popupMessage(driver),"Please fill out Username and Password.");
     homePage.handleAlert();
     softAssert.assertAll();
     Thread.sleep(1000);


    }
    @Test(priority = 2)
    public void closeSignUpPopup() throws InterruptedException {
        homePage.navigateToHomePage(driver);
        homePage.clickRegisterSignUpBtn(driver);
        homePage.typeRegisterUserName("name",driver);
        homePage.typeRegisterPassword("123",driver);
        homePage.closeSignUpPopup(driver);
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void validDataSignUp() throws InterruptedException {
        homePage.navigateToHomePage(driver);
        homePage.clickRegisterSignUpBtn(driver);
        LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        userName= "maher "+now.format(formatter);
        password=now.format(formatter);
        homePage.typeRegisterUserName(userName,driver);
        homePage.typeRegisterPassword(password,driver);
        homePage.clickSignUpBtn(driver);
        softAssert.assertEquals(homePage.popupMessage(driver),"Sign up successful.");
        homePage.handleAlert();
        softAssert.assertAll();
        Thread.sleep(1000);

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
