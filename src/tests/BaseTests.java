package tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    public ChromeDriver driver;

    public ChromeDriver getDriver() {
        return driver;
    }

    public void setDriver(ChromeDriver driver) {
        this.driver = driver;
    }
}
