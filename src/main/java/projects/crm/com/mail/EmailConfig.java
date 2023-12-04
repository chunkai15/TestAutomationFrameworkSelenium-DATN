package projects.crm.com.mail;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {

    //Nhớ tạo mật khẩu app (App Password) cho Gmail mới gửi được nhen
    //Nếu dùng mail của Hosting thì bình thường
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "selenium@gmail.com";
    public static final String PASSWORD = "hevnmnclncqaabwy";

    public static final String[] TO = {"kingkukk15@gmail.com"};
    public static final String SUBJECT = "Report | Automation Framework Selenium | Xuan Khai";
}
