package projects.crm.com.web.ecommerce.pages;

import org.openqa.selenium.By;
import static projects.crm.com.keyword.WebUI.*;

public class SignInPage {

    //Login
    private String pageUrl = "/user/login";
    private String pageTitle = "E-Shop || Login Page";
    private String messageLoginDone = "Successfully login";
    private By linkLogin = By.xpath("//a[normalize-space()='Login /']");
    private By inputEmail = By.xpath("//input[@name='email']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    public SignInPage(){
    }

    public HomePage logIn(String email, String password){
        openURL("http://127.0.0.1:8000/user/login");
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonLogin);
        //verifyEquals(getTextElement(messageInvalidEmailAndPass), messageLoginDone, "Login fail");
        //verifyElementVisible(messageInvalidEmailAndPass, "Login page is NOT displayed");
        return new HomePage();
    }
}
