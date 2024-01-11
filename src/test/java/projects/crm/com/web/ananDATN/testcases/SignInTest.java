package projects.crm.com.web.ananDATN.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import projects.crm.com.helpers.ExcelHelpers;
import projects.crm.com.web.ananDATN.pages.SignInPage;

public class SignInTest extends BaseSetup {

    public SignInPage signInPage;
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void testLogin(){
        signInPage = new SignInPage();
        excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/testdata/Book1.xlsx", "Sheet1");
        //signInPage.logIn("kun@qa.team", "123456");
        signInPage.logIn(excel.getCellData("username", 1), excel.getCellData("password", 1));
    }

    /*@Test(priority = 2)
    public void testLoginWithUsernameInvalid(){
        signInPage = new SignInPage();
        signInPage.loginWithUsernameInValid("kunnn@qa.team", "123456");
    }*/

    /*@Test(priority = 3)
    public void logOut(){
        signInPage = new SignInPage();
        signInPage.logIn("kun@qa.team", "123456");
        signInPage.logOut();
    }*/
}
