package projects.crm.com.web.ananDATN.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import projects.crm.com.web.ananDATN.pages.HomePage;

public class SearchProductTest extends BaseSetup {

    public HomePage homePage;

    /*@Test(priority = 1)
    public void testSearch(){
        homePage = new HomePage();
        homePage.searchProduct("Pierre Cardin");
    }*/

    @Test(priority = 2)
    public void testSearchAndOpenPDP(){
        homePage = new HomePage();
        homePage.searchAndOpenPDP("Pierre Cardin");
    }
}
