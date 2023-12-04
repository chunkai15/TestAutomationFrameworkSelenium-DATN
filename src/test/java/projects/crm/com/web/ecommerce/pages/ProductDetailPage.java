package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import projects.crm.com.keyword.WebUI;

public class ProductDetailPage {

    String nameItem = "Ladies Cotton Kurti Sha";
    private By nameOfItem = By.xpath("//div[@class='short']/h4");
    private By buttonAddToCart = By.xpath("//button[contains(text(),'Add to cart')]");

    public ProductDetailPage(){}

    public CartPage addToCart(){
        WebUI.waitForPageLoaded();
        WebUI.verifyContains(WebUI.getTextElement(nameOfItem), nameItem);
        WebUI.clickElementWithJs(buttonAddToCart);

        return new CartPage();
    }
}
