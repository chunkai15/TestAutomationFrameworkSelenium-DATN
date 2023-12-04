package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import static projects.crm.com.keyword.WebUI.*;

public class DashboardPage {

    private String pageTitle = "E-SHOP || DASHBOARD";
    private By orderLink = By.xpath("(//a[@class='nav-link'])[2]");
    private By inputSearch = By.xpath("//input[@type='search']");

    public DashboardPage(){}

    public void checkOrderAfterCheckout(){
        switchToWindowOrTabByTitle(pageTitle);
        waitForPageLoaded();
        clickElement(orderLink);
        setText(inputSearch, "kai@qa.team");
        checkContainsValueOnTableByColumn(4, "kai@qa.team");
        checkContainsValueOnTableByColumn(5, "1");
        checkEqualsValueOnTableByColumn(8, "new");
    }
}
