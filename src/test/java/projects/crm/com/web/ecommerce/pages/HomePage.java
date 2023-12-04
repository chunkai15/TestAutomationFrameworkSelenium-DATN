package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import projects.crm.com.keyword.WebUI;

public class HomePage {

    private By buttonShopNow = By.xpath("//section[@class='small-banner section']//div[@class='row']//div[1]//div[1]//div[1]//a[1]");
    public By messageLoginDone = By.xpath("/following-sibling::text()[1]");
    private By dashBoardLink = By.xpath("//a[normalize-space()='Dashboard']");

    public HomePage(){}

    public ProductOverviewPage openPOP()   {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonShopNow);

        return new ProductOverviewPage();
    }

    public DashboardPage openDashBoard(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dashBoardLink);

        return new DashboardPage();
    }
}
