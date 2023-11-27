package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }




    public void addProductToCartByName(String product ) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));

            if (inventoryItemName.getText().equals(product)) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }

    }

    public Integer returnItemNumber(ChromeDriver driver){
        Integer toReturn= null;

        WebElement linkShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        List<WebElement> spanItemNumbers= linkShoppingCart.findElements(By.className("shopping_cart_badge"));
        if(spanItemNumbers.size()==0){
            toReturn=0;
        }
        else {
            toReturn= Integer.parseInt(spanItemNumbers.get(0).getText());
        }

        return toReturn;
    }

    public List<Product> returnProducts(){
        List<Product> lista = new ArrayList<>();

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for ( int i = 0; i < inventoryItems.size(); i++ ){
            WebElement itemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));
            String name = itemName.getText();

            WebElement itemPrice = inventoryItems.get(i).findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(itemPrice.getText().substring(1));

            WebElement itemDescription = inventoryItems.get(i).findElement(By.className("inventory_item_desc"));
            String description = itemDescription.getText();

            Product product = new Product(name, price, description);
            lista.add(product);
        }
        return lista;
    }

    public void openCart(){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
    }

}
