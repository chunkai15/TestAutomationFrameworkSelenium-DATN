package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import projects.crm.com.keyword.WebUI;

import java.util.ArrayList;
import java.util.List;

import static projects.crm.com.keyword.WebUI.getTextElement;

public class CheckoutPage {

    private By inputFirstName = By.xpath("//input[@name='first_name']");
    private By inputLastName = By.xpath("//input[@name='last_name']");
    private By inputEmail = By.xpath("//input[@name='email']");
    private By inputPhone = By.xpath("//input[@name='phone']");
    private By dropdownCt = By.xpath("//div[@class='form-group']//div[@class='nice-select']");
    private By dropdownOption = By.xpath("//div[@class='form-group']//div[@class='nice-select open']//li[normalize-space()='Vietnam']");
    private By inputAddress = By.xpath("//input[@name='address1']");
    private By inputPostcode = By.xpath("//input[@name='post_code']");
    private By dropdownShippingCost = By.xpath("//li[@class='shipping']//div[@class='nice-select']");
    private By optionShippingCost = By.xpath("//li[@class='shipping']//div[@class='nice-select open']//li[normalize-space()='Pokhara: $400.00']");
    private By radioPayments = By.xpath("//input[@value='cod']");
    private By buttonProceedCheckout = By.xpath("//button[normalize-space()='proceed to checkout']");
    public By totalPrice = By.xpath("//li[@id='order_total_price']//span[1]");
    String total = getTextElement(totalPrice);
    /*String shippingCost = getTextElement(optionShippingCost);
    *//*int itemTotal = Integer.parseInt(total);
    String subTotal = String.valueOf(subTotalInt);*/
    private List<String> list;

    public CheckoutPage(){
        list = new ArrayList<String>();
        list.add(total);
    }

    public List<String> getList() {
        return list;
    }

    public DashboardPage proceedToChecout(){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputFirstName, "Chun");
        WebUI.setText(inputLastName, "Kai");
        WebUI.setText(inputEmail, "kai@qa.team");
        WebUI.setText(inputPhone, "0901253624");
        WebUI.clickElementWithJs(dropdownCt);
        WebUI.clickElementWithJs(dropdownOption);
        WebUI.setText(inputAddress, "430 Nguyen Phuoc Nguyen, Thanh Khe, Da Nang");
        WebUI.setText(inputPostcode, "50000");
        WebUI.clickElementWithJs(dropdownShippingCost);
        WebUI.clickElementWithJs(optionShippingCost);
        WebUI.clickElement(radioPayments);
        WebUI.clickElement(buttonProceedCheckout);

        return new DashboardPage();
    }

}
