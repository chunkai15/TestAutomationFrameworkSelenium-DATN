package projects.crm.com.web.ananDATN.pages;

import static projects.crm.com.keyword.WebUI.*;
import org.openqa.selenium.By;

public class CheckoutPage {

    private By changeAddressButton = By.xpath("//a[contains(text(),'Thay đổi')]");
    private By cartButton = By.xpath("//button[@class='action-btn btn-cart']");
    private By checkoutButtonInCart = By.xpath("//a[contains(text(),'Thanh')]");
    private By checkoutButton = By.xpath("//button[normalize-space()='Thanh Toán']");
    private By counponSection = By.xpath("//p[contains(text(),'Phương thức thanh toán')]");
    private By counponField = By.xpath("//input[@id='coupons-text']");
    private By toggleButton = By.xpath("//tbody/tr[2]/td[4]/label[1]/div[1]");
    private By subTotal = By.xpath("//p[@class='font-semibold text-gray-900 price-product']");
    private By counponPrice = By.xpath("//p[@class='font-semibold text-gray-900 text-coupons']");
    private By shippingFee = By.xpath("//p[@class='font-semibold text-gray-900 text-cost-shipping']");
    private By total = By.xpath("//p[@class='text-2xl font-semibold text-gray-900 text-total-price-checkout']");

    public CheckoutPage(){
    }

    public void proceedToCheckout(){
        waitForPageLoaded();
        clickElement(changeAddressButton);
        clickElementWithJs(toggleButton);
        clickElement(cartButton);
        clickElement(checkoutButtonInCart);
        scrollToElement(checkoutButton);
        clickElement(checkoutButton);
    }

    public void proceedToCheckoutWithCounpon(){
        waitForPageLoaded();
        scrollToElement(counponSection);
        sleep(4);
        setText(counponField, "oy7pfps3j0");
        //sleep(2);
        //clickElement(subTotal);
        String subTotalAsString = getTextElement(subTotal).trim();
        String counponPriceAsString = getTextElement(counponPrice).trim();
        String shippingFeeAsString = getTextElement(shippingFee).trim();
        String totalAsString = getTextElement(total).trim();
        int shippingFeeAsInt = Integer.parseInt(shippingFeeAsString.replace("đ", "").replace(".", "").split("\\.")[0]);
        int subTotalAsInt = Integer.parseInt(subTotalAsString.replace("đ", "").replace(".", "").split("\\.")[0]);
        int subTotalAsIntAfterCounpon = (int) (subTotalAsInt * (30.0/100.0));
        int counponPriceAsInt = (Integer.parseInt(counponPriceAsString.replace("đ", "").replace(".", "").split("\\.")[0])) * (-1);
        int totalAsInt = Integer.parseInt(totalAsString.replace("đ", "").replace(".", "").split("\\.")[0]);
        System.out.println(subTotalAsInt + " " + counponPriceAsInt + " " + totalAsInt + " " + subTotalAsIntAfterCounpon);
        sleep(2);
        int sumPrice = subTotalAsInt - counponPriceAsInt + shippingFeeAsInt;
        verifyEquals(counponPriceAsInt, subTotalAsIntAfterCounpon);
        verifyEquals(sumPrice, totalAsInt, "The total price is failed");
        sleep(2);
        clickElement(checkoutButton);
    }
}
