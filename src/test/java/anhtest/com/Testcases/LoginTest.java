package anhtest.com.Testcases;

import anhtest.com.Pages.LoginPage;
import anhtest.com.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void validLogin(){
        System.out.println(driver);
        //Khoi tao object LoginPage va get driver from BaseTest
        loginPage = new LoginPage(driver);

        //Goi ham login function from LoginPage
        loginPage.loginValidEmail("admin@example.com", "123");
    }
    @Test
    public void invalidLogin(){
        loginPage = new LoginPage(driver);
        loginPage.loginInvalidEmail("admin@example.com123", "123");

    }
}
