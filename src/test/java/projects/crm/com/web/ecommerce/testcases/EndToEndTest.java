package projects.crm.com.web.ecommerce.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import projects.crm.com.web.ecommerce.pages.*;

import java.util.Arrays;

import static projects.crm.com.keyword.WebUI.*;

public class EndToEndTest extends BaseSetup {

    private SignInPage signInPage;
    private HomePage homePage;
    private ProductOverviewPage productOverviewPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private DashboardPage dashboardPage;

    @Test(priority = 1)
    public void addItemToCart() throws InterruptedException {
        signInPage = new SignInPage();
        homePage = signInPage.logIn("user@gmail.com", "1111");
        productOverviewPage = homePage.openPOP();
        productDetailPage = productOverviewPage.openPDP();
        cartPage = productDetailPage.addToCart();
        cartPage.openCart();
        checkoutPage = cartPage.goToCheckoutPage();
        dashboardPage = checkoutPage.proceedToChecout();
        dashboardPage = homePage.openDashBoard();
        dashboardPage.checkOrderAfterCheckout();

        /*String total = Arrays.toString(checkoutPage.getList().toArray());
        String total1 = total.replace("$", "");
        String total2 = total1.replace("[", "");
        String total3 = total2.replace("]", "");
        String total4 = total3.replace(".00", "");
        //String total5 = total4.replace(",", ".");
        double itemTotal = Double.parseDouble(total4);

        String shippingCost = Arrays.toString(getValueTableByColumn(5).toArray());
        String shippingCost1 = shippingCost.replace("$", "");
        String shippingCost2 = shippingCost1.replace("[", "");
        String shippingCost3 = shippingCost2.replace("]", "");
        String shippingCost4 = shippingCost3.replace(".00", "");
        //String shippingCost5 = shippingCost4.replace(",", ".");
        double itemshippingCost = Double.parseDouble(shippingCost4);

        double subTotal = itemTotal + itemshippingCost;
        String subTotalString = String.valueOf(subTotal);
        checkContainsValueOnTableByColumn(7, subTotalString);*/
    }

    /*@Test(priority = 2)
    public void goToPOP()  {
        productOverviewPage = homePage.openPOP();
    }

    @Test(priority = 3)
    public void goToPDP(){
        productDetailPage = productOverviewPage.openPDP();
    }

    @Test(priority = 4)
    public void goToCart(){
        cartPage = productDetailPage.addToCart();
    }

    @Test(priority = 5)
    public void openCart(){
        cartPage.openCart();
    }*/

}
