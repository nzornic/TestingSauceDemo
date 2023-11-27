package tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.LoginPage;

public class VerifyingTests extends BaseTests {

    @BeforeClass
    public void driverSetup (){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Driver\\chromedriver_win32\\chromedriver.exe");
        super.driver = new ChromeDriver();
    }
    @AfterClass
    public void driverClose() {
        super.driver.quit();
    }

    @Test
    public void verifyAddProductToCart(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage= new ProductsPage(driver);
        Integer beforeAdd = productPage.returnItemNumber(driver);
        productPage.addProductToCartByName("Sauce Labs Bike Light");
        Integer afterAdd = productPage.returnItemNumber(driver);

        Assert.assertEquals(afterAdd, beforeAdd + 1, "Product number is not equal");


    }




}
