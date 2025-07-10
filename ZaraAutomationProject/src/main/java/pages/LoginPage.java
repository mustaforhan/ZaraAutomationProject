package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import org.apache.log4j.Logger;

public class LoginPage {
    private WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(LoginPage.class);

    private By loginIcon = By.cssSelector("a[data-tracking-label='header-myaccount']");
    private By emailInput = By.cssSelector("input[name='logonId']");
    private By passwordInput = By.cssSelector("input[name='password']");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginIcon() {
        driver.findElement(loginIcon).click();
        logger.info("Giriş simgesine tıklandı.");
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        logger.info("E-posta girildi.");
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        logger.info("Şifre girildi.");
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        logger.info("Giriş yap butonuna tıklandı.");
    }

    public void login(String email, String password) {
        clickLoginIcon();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
