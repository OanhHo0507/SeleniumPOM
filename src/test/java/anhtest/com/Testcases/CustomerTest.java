package anhtest.com.Testcases;

import anhtest.com.Pages.CustomerPage;
import anhtest.com.Pages.DashboardPage;
import anhtest.com.Pages.LoginPage;
import anhtest.com.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @Test
    public void testTotalDashboard(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        customerPage = new CustomerPage(driver);
        loginPage.loginValidEmail("admin@example.com", "123456");
        dashboardPage.verifyDashboardLink();
        dashboardPage.openCustomerPage();
        customerPage.verifyCustomerPage();

    }
}
