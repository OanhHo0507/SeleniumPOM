package anhtest.com.Pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private String CUSTOMER_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customer";
    private By headerCustomer = By.xpath("//div[@class='mbot15']/h4[contains(.,'" + PAGE_TEXT + "')]");
    private WebDriver driver;

    //Ham xay dung de truyen vao driver
    public CustomerPage (WebDriver driver){
        this.driver = driver;

    }
    public void verifyCustomerPage() {
        //Check URL of Customer page
        Assert.assertEquals(driver.getCurrentUrl(), CUSTOMER_URL, "This is not URL of Customer page");

        //Check Customer Summary header exists in Customer page
        //Assert.assertTrue(driver.findElement(headerCustomer).isDisplayed(), "FAIL. This is not Customer page.");
        Assert.assertTrue(WebUI.checkElementExist(driver,headerCustomer), "FAIL. Header Page Customer does not exist.");
        System.out.println(driver.findElement(headerCustomer).getText());
        Assert.assertEquals(driver.findElement(headerCustomer).getText(), "Customers Summary", "Customer Summary is not displayed.");
    }

}
