package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> itemsInCart(){

        List<String> productAttributes = new ArrayList<>();

        WebElement cartList = driver.findElement(By.className("cart_list"));
        List<WebElement> cartItems = cartList.findElements(By.className("cart_item"));

        for( int i = 0; i < cartItems.size(); i++){
            WebElement inventoryItemName = cartItems.get(i).findElement(By.className("inventory_item_name"));
            String name = inventoryItemName.getText();
            productAttributes.add(name);

            WebElement inventoryItemPrice = cartItems.get(i).findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(inventoryItemPrice.getText().substring(1));
            productAttributes.add(String.valueOf(price));

            WebElement inventoryItemDescription = cartItems.get(i).findElement(By.className("inventory_item_desc"));
            String description = inventoryItemDescription.getText();
            productAttributes.add(description);
        }
        return productAttributes;
    }

    public void openCheckout() {
        WebElement checkout = driver.findElement(By.xpath("//button[@name='checkout']"));
        checkout.click();
    }
}
