package anhtest.com.Pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";
    By totalConvertedLeads = By.xpath("(//div[@class='top_stats_wrapper']//div[@class='tw-font-medium tw-inline-flex text-neutral-600 tw-items-center'])[2]");
    By headerDashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    By menuCustomer = By.xpath("//span[normalize-space() ='Customers']");

    By menuDashboard = By.xpath("//span[normalize-space() ='Dashboard']");

    By checkboxQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");
    By widgetQuickStatistics = By.xpath("//div[@id = 'widget-top_stats']");

    private WebDriver driver;

    //Ham xay dung de truyen vao driver
    public DashboardPage (WebDriver driver){
        this.driver = driver;

    }
    public void verifyDashboardLink() {
        //Check URL of Dashboard page
        Assert.assertEquals(driver.getCurrentUrl(), PAGE_URL, "This is not URL of Dashboard page");
        //Check total of Converted Leads in Dashboard page
        String totalDashboard = driver.findElement(totalConvertedLeads).getText();
        System.out.println(totalDashboard);
        Assert.assertEquals(totalDashboard, "Converted Leads", "Converted Leads section is not displayed.");
        Assert.assertTrue(driver.findElement(totalConvertedLeads).isDisplayed(), "FAIL. This is not Dashboard page.");
        // Check Dashboard Options in Dashboard page
        System.out.println(driver.findElement(headerDashboardOptions).getText());
        Assert.assertEquals(driver.findElement(headerDashboardOptions).getText(), PAGE_TEXT, "Dashboard Options is not displayed.");
        Assert.assertTrue(driver.findElement(headerDashboardOptions).isDisplayed(), "FAIL. This is not Dashboard page.");
        //Assert.assertTrue(WebUI.checkElementExist(driver,headerDashboardOptions),"Dashboard Options is not displayed");
    }
    public void verifyVisibleWidget(){

        //Check Quick Statistics checkbox is visible
        Assert.assertTrue(WebUI.verifyElementVisibility(driver, widgetQuickStatistics, 5), "Widget Quick Statistics is visible by default.");

        //CLick on Dashboard Options button
        driver.findElement(headerDashboardOptions).click();
        WebUI.waitForElementVisible(driver, checkboxQuickStatistics, 5);

        //Click on Quick Statistics checkbox to uncheck
        driver.findElement(checkboxQuickStatistics).click();

        //Check Quick Statistics widget is invisible after clicking checkbox quick statistics
        Assert.assertTrue(WebUI.verifyElementNOTVisibility(driver, widgetQuickStatistics, 5), "Widget Quick Statistics is not visible after unchecking Quick...checkbox.");


    }

    public CustomerPage openCustomerPage(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();

        return new CustomerPage(driver);
    }
}
