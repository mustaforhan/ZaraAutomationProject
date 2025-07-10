package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class CartPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(CartPage.class);

    private By cartPrice = By.cssSelector(".shopping-cart__total-price");
    private By quantityDropdown = By.cssSelector("select.quantity-selector");
    private By quantityValue = By.cssSelector("select.quantity-selector option[selected]");
    private By deleteButton = By.cssSelector("button.remove-product-button");
    private By emptyCartMessage = By.cssSelector(".shopping-cart__empty");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartPrice() {
        String price = driver.findElement(cartPrice).getText().trim();
        logger.info("Sepetteki ürün fiyatı alındı: " + price);
        return price;
    }

    public void increaseQuantityToTwo() {
        WebElement dropdown = driver.findElement(quantityDropdown);
        dropdown.sendKeys("2");
        logger.info("Ürün adedi 2 olarak seçildi.");
    }

    public boolean isQuantityTwo() {
        String selected = driver.findElement(quantityValue).getText().trim();
        boolean result = selected.equals("2");
        logger.info("Ürün adedi doğrulandı mı? " + result);
        return result;
    }

    public void deleteProduct() {
        driver.findElement(deleteButton).click();
        logger.info("Ürün sepetten silindi.");
    }

    public boolean isCartEmpty() {
        boolean isEmpty = driver.findElements(emptyCartMessage).size() > 0;
        logger.info("Sepet boş mu? " + isEmpty);
        return isEmpty;
    }
}
