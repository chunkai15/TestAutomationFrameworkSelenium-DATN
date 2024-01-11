package projects.crm.com.web.ananDATN.testcases;

import org.testng.annotations.Test;
import projects.crm.com.common.BaseSetup;
import projects.crm.com.helpers.ExcelHelpers;
import projects.crm.com.web.ananDATN.pages.*;

import java.util.ArrayList;

public class EndToEndTest extends BaseSetup {

    public ExcelHelpers excel;
    public ExcelHelpers excel2;
    public SignInPage signInPage;
    public HomePage homePage;
    public ProductDetailPage productDetailPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @Test(priority = 1)
    public void endToEndTest(){
        signInPage = new SignInPage();
        excel = new ExcelHelpers();
        excel2 = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/testdata/Book1.xlsx", "Sheet1");
        excel2.setExcelFile("src/test/resources/testdata/GetProductInfo1.xlsx", "ProductInfo");
        homePage = signInPage.logIn(excel.getCellData("username", 1), excel.getCellData("password", 1));
        productDetailPage = homePage.searchAndOpenPDP("Pierre Cardin");
        ArrayList productInfo = productDetailPage.productInfo();
        int lastRow = excel2.getRows();
        int newRow = lastRow + 1;
        excel2.setCellData(String.valueOf(newRow), newRow, 0);
        for (int i = 0; i < productInfo.size(); i++) {
            if (String.valueOf(newRow) != null) {
                excel2.setCellData((String) productInfo.get(i), newRow, i + 1);
            }
        }
        cartPage = productDetailPage.addToCart("1");
        checkoutPage = cartPage.goToCheckout();
        checkoutPage.proceedToCheckoutWithCounpon();
    }
}
