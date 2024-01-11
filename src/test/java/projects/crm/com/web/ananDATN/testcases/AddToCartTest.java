package projects.crm.com.web.ananDATN.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import projects.crm.com.web.ananDATN.pages.HomePage;
import projects.crm.com.web.ananDATN.pages.ProductDetailPage;

public class AddToCartTest extends BaseSetup {

    public ProductDetailPage productDetailPage;
    public HomePage homePage;

    @Test(priority = 1)
    public void testAddToCart(){
        productDetailPage = new ProductDetailPage();
        homePage = new HomePage();
        homePage.searchAndOpenPDP("Pierre Cardin");
        productDetailPage.addToCart("1");
    }
}
