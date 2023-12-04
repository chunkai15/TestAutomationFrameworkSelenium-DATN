package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import projects.crm.com.driver.DriverManager;
import projects.crm.com.keyword.WebUI;

import java.util.List;
import java.util.Random;

public class ProductOverviewPage {

    private By changeGrid = By.xpath("//body/form[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");

    public ProductOverviewPage(){}

    public ProductDetailPage openPDP()  {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(changeGrid);
        List<WebElement> listOfProduct = DriverManager.getDriver().findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-12']"));
        //System.out.println("list size: " +listOfProduct.size());
        /*Random r = new Random();
        int randomValue = r.nextInt(listOfProduct.size());
        WebUI.scrollToElement(listOfProduct.get(randomValue));
        listOfProduct.get(randomValue).click();*/
        for (int i = 0; i < listOfProduct.size(); i++) {
            //System.out.println("Print complete Content : " + listOfProduct.get(i).getText());
            if (listOfProduct.get(i).getText().contains("Ladies Cotton Kurti Sha")) {
                // move to a specific element
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",
                        listOfProduct.get(i));
                // move slightly up as blue header comes in the picture
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,-100)");
                // then click on the element
                listOfProduct.get(i).click();
                break;
            }
        }

        return new ProductDetailPage();
    }
}
