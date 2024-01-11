package projects.crm.com.web.ananDATN.pages;

import org.openqa.selenium.By;

import static projects.crm.com.keyword.WebUI.*;

public class SignInPage {

    private String pageUrl = "/auth";
    private String pageTitle = "Đăng nhập";
    private String accountInfoText = "Thông tin tài khoản";
    private String errorMessagee = "Đăng nhập không thành công! Vui lòng kiểm tra lại thông tin!";
    private String messageLoginDone = "Successfully login";
    private By linkLogin = By.xpath("//a[@class='action-btn']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[@id='btn-login']");
    private By accountInfo = By.xpath("//h2[contains(text(),'Thông tin tài khoản')]");
    private By errorMessage = By.xpath("//p[@class='notiflix-report-message']");
    private By dropDown = By.xpath("//a[@id='dropdownAvatarNameButton']");
    private By logOutLink = By.xpath("/html[1]/body[1]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]");


    public SignInPage(){
    }

    public HomePage logIn(String email, String password){
        openURL("https://ecommerce.kendzz.com/");
        waitForPageLoaded();
        clickElement(linkLogin);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonLogin);
        clickElementWithJs(dropDown);
        verifyEquals(getTextElement(accountInfo), accountInfoText, "Account info not match");

        return new HomePage();
    }

    public void loginWithUsernameInValid(String email, String password){
        openURL("https://ecommerce.kendzz.com/");
        waitForPageLoaded();
        clickElement(linkLogin);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonLogin);
        verifyElementVisible(errorMessage);
        verifyEquals(getTextElement(errorMessage), errorMessagee, "Login fail");
    }

    public void logOut(){
        /*openURL("https://ecommerce.kendzz.com/");
        waitForPageLoaded();*/
        mouseHover(dropDown);
        clickElementWithJs(logOutLink);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
    }
}
