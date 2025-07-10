package tests;

import base.DriverBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ExcelUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ZaraTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverBase.getDriver();
    }

    @Test
    public void testZaraE2EFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("email@example.com", "password123");
        Thread.sleep(4000);

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToErkekTumunuGor();
        Thread.sleep(3000);

        List<String> urunler = ExcelUtil.readProductList("data/input.xlsx");
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchTerm(urunler.get(0));
        Thread.sleep(2000);
        searchPage.clearSearchBox();
        Thread.sleep(1000);

        searchPage.enterSearchTerm(urunler.get(1));
        searchPage.pressEnter();
        Thread.sleep(4000);

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.selectRandomProduct();
        Thread.sleep(3000);

        ProductPage productPage = new ProductPage(driver);
        productPage.writeProductInfoToFile("data/output.txt");
        String urunFiyati = productPage.getProductPrice();
        productPage.addToCart();
        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        String sepetFiyati = cartPage.getCartPrice();
        assertEquals("Fiyat doğrulaması başarısız!", urunFiyati, sepetFiyati);

        cartPage.increaseQuantityToTwo();
        Thread.sleep(2000);
        assertTrue("Ürün adedi 2 değil!", cartPage.isQuantityTwo());

        cartPage.deleteProduct();
        Thread.sleep(2000);
        assertTrue("Sepet boş değil!", cartPage.isCartEmpty());
    }

    @After
    public void tearDown() {
        DriverBase.quitDriver();
    }
}
