package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

public class ResultsPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(ResultsPage.class);

    private By productList = By.cssSelector("a.product-link");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectRandomProduct() {
        List<WebElement> products = driver.findElements(productList);
        if (products.size() == 0) {
            logger.error("Ürün bulunamadı!");
            return;
        }

        Random rand = new Random();
        WebElement selectedProduct = products.get(rand.nextInt(products.size()));
        logger.info("Rastgele ürün seçildi: " + selectedProduct.getAttribute("href"));
        selectedProduct.click();
    }
}
