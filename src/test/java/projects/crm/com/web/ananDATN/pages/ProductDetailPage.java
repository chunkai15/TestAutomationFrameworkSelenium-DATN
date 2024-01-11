package projects.crm.com.web.ananDATN.pages;

import static projects.crm.com.keyword.WebUI.*;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDetailPage {

    private String errorMessagee = "Số lượng sản phẩm phải lớn hơn 0";
    private By productName = By.xpath("//h3[@class='!text-xl showcase-title']");
    private By productPrice = By.cssSelector("div[class='showcase-container product-content'] p[class='price']");
    private By productRate = By.xpath("(//div[@class='flex-none ml-2'])[1]");
    private By productSaleNum = By.xpath("(//div[@class='flex-none ml-2'])[2]");
    private By quantityField = By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1]");
    private By addToCartButton = By.xpath("//button[contains(text(),'Thêm vào giỏ hàng')]");
    private By errorMessage = By.xpath("//span[contains(text(),'Số lượng sản phẩm phải lớn hơn 0')]");

    public ProductDetailPage(){
    }

    public CartPage addToCart(String quantity){
        waitForPageLoaded();
        clearText(quantityField);
        setText(quantityField, quantity);
        clickElement(addToCartButton);
        return new CartPage();
    }

    public void addWhileNotEnterQuantity(){
        waitForPageLoaded();
        clickElement(addToCartButton);
        verifyElementVisible(errorMessage);
        verifyContains(getTextElement(errorMessage), errorMessagee);
    }

    public ArrayList productInfo(){
        waitForPageLoaded();
        String name = getTextElement(productName);
        String price = getTextElement(productPrice);
        String rate = getTextElement(productRate);
        String saleNum = getTextElement(productSaleNum);
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(name);
        arrayList.add(price);
        arrayList.add(rate);
        arrayList.add(saleNum);
        System.out.println("Array" + arrayList);
        System.out.println("Array" + arrayList.get(0));
        return (ArrayList) arrayList;
    }
}
