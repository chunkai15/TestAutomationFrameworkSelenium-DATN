package projects.crm.com.web.ananDATN.pages;
import static projects.crm.com.keyword.WebUI.*;

import org.openqa.selenium.By;

public class CartPage {

    private By cartButton = By.xpath("//button[@class='action-btn btn-cart']");
    private By checkoutButton = By.xpath("//a[contains(text(),'Thanh')]");
    private By chiTietThanhToan = By.xpath("//p[contains(text(),'Chi tiết thanh toán')]");

    public CartPage(){
    }

    public CheckoutPage goToCheckout(){
        waitForPageLoaded();
        clickElementWithJs(cartButton);
        clickElementWithJs(checkoutButton);
        waitForElementPresent(chiTietThanhToan);

        return new CheckoutPage();
    }

    public void checkProductInCart(){
    }

    public void removeProductFromCart(){
    }
}
