package projects.crm.com.web.ananDATN.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import projects.crm.com.driver.DriverManager;

import java.util.List;
import java.util.Random;

import static projects.crm.com.keyword.WebUI.*;

public class HomePage {

    private Random randomGenerator;

    private By searchField = By.xpath("//header/div[2]/div[1]/form[1]/input[1]");
    private By categoryTrangChu = By.xpath("//a[contains(text(),'Trang chủ')]");
    private By categoryDanhMuc = By.xpath("//a[contains(text(),'Danh mục')]");
    private By categoryNam = By.xpath("//a[contains(text(),'Nam')]");
    private By categoryNu = By.xpath("//a[contains(text(),'Nữ')]");
    private By categoryPhuKien = By.xpath("//a[contains(text(),'Phụ kiện')]");
    //private By categoryDanhMuc = By.xpath("//a[contains(text(),'Danh mục')]");
    private By categoryDoChoi= By.xpath("//a[@class='menu-title'][contains(text(),'i - M')]");
    private By categoryBlog = By.xpath("//a[contains(text(),'Blog')]");
    private By categoryUuDai = By.xpath("//a[contains(text(),'Ưu đãi hấp dẫn')]");
    private By dealOfTheDaySection = By.xpath("//h2[normalize-space()='Deal of the day']");
    private By newProductSection = By.xpath("//h2[normalize-space()='New Products']");
    private By bestSellerSection = By.xpath("//h3[normalize-space()='best sellers']");
    private By testimonialSection = By.xpath("//h2[normalize-space()='testimonial']");
    private By ourServiceSection = By.xpath("//h2[normalize-space()='Our Services']");
    private By popularSection = By.xpath("//h2[normalize-space()='Popular Categories']");
    private By productsSection = By.xpath("//h2[normalize-space()='Products']");
    private By ourCompanySection = By.xpath("//h2[normalize-space()='Our Company']");
    private By servicesSection = By.xpath("//h2[normalize-space()='Services']");
    private By contactSection = By.xpath("//h2[normalize-space()='Contact']");


    public HomePage(){
    }

    public void checkVisibleSection(){

    }

    public void searchProduct(String searchKeyword){
        openURL("https://ecommerce.kendzz.com/");
        waitForPageLoaded();
        clearText(searchField);
        setText(searchField,searchKeyword);
        pressENTER();
        waitForPageLoaded();
        List<WebElement> listOfProduct = DriverManager.getDriver().findElements(By.xpath("//div[@class='product-grid']"));
        for (int i = 0; i < listOfProduct.size(); i++) {
            //System.out.println("Print complete Content : " + listOfProduct.get(i).getText());
            verifyContains(listOfProduct.get(i).getText(), searchKeyword, "Search result validation failed at instance [ + i + ].");

        }
    }

    public ProductDetailPage searchAndOpenPDP(String searchKeyword){
        openURL("https://ecommerce.kendzz.com/");
        waitForPageLoaded();
        clearText(searchField);
        setText(searchField,searchKeyword);
        pressENTER();
        waitForPageLoaded();
        List<WebElement> listOfProduct = DriverManager.getDriver().findElements(By.xpath("//div[@class='showcase']"));
        System.out.println(listOfProduct.size());
        for (int i = 0; i < listOfProduct.size(); i++) {
            //System.out.println("Print complete Content : " + listOfProduct.get(i).getText());
            if (listOfProduct.get(i).getText().contains(searchKeyword)) {
                // move to a specific element
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",
                        listOfProduct.get(i));
                // move slightly up as blue header comes in the picture
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,-100)");
                // then click on the element
                By productName = By.xpath("(//h3[@class='showcase-title'])[" + new Random().nextInt(listOfProduct.size()) +"]");
                clickElementWithJs(productName);
                break;
            }
        }
        waitForPageLoaded();
        return new ProductDetailPage();
    }
}
