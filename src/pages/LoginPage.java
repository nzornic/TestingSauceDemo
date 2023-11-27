package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }


    public void login(String username, String password){

        WebElement inputUserName= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");


        WebElement inputPassword= driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogIn= driver.findElement(By.id("login-button"));
        buttonLogIn.click();

    }

}
