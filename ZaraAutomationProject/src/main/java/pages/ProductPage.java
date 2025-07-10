package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FileUtil;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class ProductPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(ProductPage.class);

    private By productName = By.cssSelector("h1.product-name");
    private By productPrice = By.cssSelector("span.price__amount");
    private By addToCartButton = By.cssSelector("button.add-to-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        String name = driver.findElement(productName).getText().trim();
        logger.info("Ürün adı alındı: " + name);
        return name;
    }

    public String getProductPrice() {
        String price = driver.findElement(productPrice).getText().trim();
        logger.info("Ürün fiyatı alındı: " + price);
        return price;
    }

    public void writeProductInfoToFile(String filePath) {
        String name = getProductName();
        String price = getProductPrice();
        FileUtil.writeProductInfo(name, price, filePath);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
        logger.info("Ürün sepete eklendi.");
    }
}
