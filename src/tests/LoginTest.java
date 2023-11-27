package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginTest {

    public void VerifyLoginWithStandardUser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Driver\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");


        }
    }

}
