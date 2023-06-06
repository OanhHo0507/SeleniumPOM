package anhtest.com.Pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signinBtn;


    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // Và khởi tạo initElements
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//Khoi tao Element sau khi khai bao @FindBy
    }

    // Chúng ta viết hàm signin không cần dùng các hàm bổ trợ enter hay click nữa
    public void signin(String username, String password) {
        driver.get(URL);
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signinBtn.click();
        WebUI.sleep(2);
    }
}
