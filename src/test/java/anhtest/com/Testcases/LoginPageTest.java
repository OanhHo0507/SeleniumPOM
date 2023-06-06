package anhtest.com.Testcases;

import anhtest.com.Pages.LoginPage;
import anhtest.com.Pages.LoginPageFactory;
import anhtest.com.common.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPageFactory loginPageFactory;
    @Test
    public void validLogin1(){
        //Khoi tao object LoginPage va get driver from BaseTest
        loginPageFactory = new LoginPageFactory(driver);

        //Goi ham login function from LoginPage
        loginPageFactory.signin("admin@example.com", "123456");
    }

}
