package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Checkout {

    private WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void inputValidCheckoutCredentials (String firstName, String lastName, Integer zipCode){

        WebElement inputFirstName = driver.findElement(By.xpath("//input[@data-test='firstName']"));
        inputFirstName.clear();
        inputFirstName.sendKeys("Nikola");

        WebElement inputLastName = driver.findElement(By.xpath("//input[@data-test='lastName']"));
        inputLastName.clear();
        inputLastName.sendKeys("Zornic");

        WebElement inputZipCode = driver.findElement(By.xpath("//input[@data-test='postalCode']"));
        inputZipCode.clear();
        inputZipCode.sendKeys("32000");

        WebElement continueButton = driver.findElement(By.xpath("//input[@data-test ='continue']"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.xpath("//button[@data-test='finish']"));
        finishButton.click();

    }

    @Test
    public void inputInvalidCheckoutCredentials (String firstName, String lastName, Integer zipCode){

        WebElement inputFirstName = driver.findElement(By.xpath("//input[@data-test='firstName']"));
        inputFirstName.clear();
        inputFirstName.sendKeys("");

        WebElement inputLastName = driver.findElement(By.xpath("//input[@data-test='lastName']"));
        inputLastName.clear();
        inputLastName.sendKeys("");

        WebElement inputZipCode = driver.findElement(By.xpath("//input[@data-test='postalCode']"));
        inputZipCode.clear();
        inputZipCode.sendKeys("");

        WebElement continueButton = driver.findElement(By.xpath("//input[@data-test ='continue']"));
        continueButton.click();

    }
}
