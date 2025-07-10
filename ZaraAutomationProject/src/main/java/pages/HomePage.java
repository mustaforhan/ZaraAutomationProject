package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class HomePage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(HomePage.class);
    private By searchBox = By.cssSelector("input[name='searchTerm']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://www.zara.com/");
        logger.info("Zara ana sayfası açıldı.");
    }

    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Ürün arandı: " + productName);
    }
}
