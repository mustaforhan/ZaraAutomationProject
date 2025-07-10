package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class MenuPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(MenuPage.class);

    private By menuButton = By.cssSelector("button[aria-label='Menü']");
    private By erkekLink = By.xpath("//span[text()='ERKEK']");
    private By tumunuGorButton = By.xpath("//span[contains(text(),'Tümünü gör')]");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(menuButton).click();
        logger.info("Menü butonuna tıklandı.");
    }

    public void clickErkekCategory() {
        WebElement erkek = driver.findElement(erkekLink);
        erkek.click();
        logger.info("ERKEK kategorisine tıklandı.");
    }

    public void clickTumunuGor() {
        WebElement tumunuGor = driver.findElement(tumunuGorButton);
        tumunuGor.click();
        logger.info("Tümünü Gör butonuna tıklandı.");
    }

    public void navigateToErkekTumunuGor() {
        openMenu();
        clickErkekCategory();
        clickTumunuGor();
    }
}
