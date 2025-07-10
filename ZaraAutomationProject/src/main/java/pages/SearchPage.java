package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class SearchPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(SearchPage.class);

    private By searchBox = By.cssSelector("input[name='searchTerm']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        WebElement input = driver.findElement(searchBox);
        input.sendKeys(term);
        logger.info("Arama kutusuna '" + term + "' kelimesi girildi.");
    }

    public void pressEnter() {
        WebElement input = driver.findElement(searchBox);
        input.sendKeys(Keys.ENTER);
        logger.info("Enter tuşuna basıldı.");
    }

    public void clearSearchBox() {
        WebElement input = driver.findElement(searchBox);
        input.clear();
        logger.info("Arama kutusu temizlendi.");
    }
}
