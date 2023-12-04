package projects.crm.com.web.ecommerce.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import static projects.crm.com.keyword.WebUI.*;
import projects.crm.com.web.ecommerce.pages.SignInPage;



public class SignInTest extends BaseSetup {

    private String pageTitle = "E-SHOP || HOME PAGE";
    public SignInPage signInPage;

    @Test(priority = 1)
    public void testLogin() {
        signInPage = new SignInPage();
        signInPage.logIn("user@gmail.com", "1111");
        verifyEquals(getPageTitle(), pageTitle);
    }
}
