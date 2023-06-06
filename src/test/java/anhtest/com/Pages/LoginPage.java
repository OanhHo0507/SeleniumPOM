package anhtest.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";
    private WebDriver driver;

    //Save Object of Login page
    //Dung doi tuong By trong Selenium de khai bao ten Object cung gia tri Locator tuong ung
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By rememberCheckbox = By.xpath("//label[@for='remember']");
    By forgetPassword = By.xpath("//a[normalize-space()='Forgot Password?']") ;
    By emailErrorMessage = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    By passwordErrorMessage = By.xpath("//div[normalize-space()='The Password field is required.']");
    By invalidEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    //Ham xay dung de truyen vao driver
    public LoginPage (WebDriver _driver){
        driver = _driver;

    }
    //Viet cac ham xu ly cho trang Login
    public void verifyHeaderPage(){
        System.out.println("Header cua login page: " + driver.findElement(headerPage).getText());
        Assert.assertEquals(driver.findElement(headerPage).getText(),"Login","FAIL. This is not Login page.");
    }
    //Kiem tra title cua Login page
    public String getSignInPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        return pageTitle;
    }

    public void enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void verifyErrorMessage(){
        Assert.assertTrue(driver.findElement(invalidEmail).isDisplayed(),"FAIL. The error message does not display");
        Assert.assertEquals(driver.findElement(invalidEmail).getText(), "Invalid email or password", "The error message does not match as expected.");
    }
    public void clickOnLoginButton(){
        driver.findElement(buttonLogin).click();
    }
    public DashboardPage loginValidEmail(String email, String password){
        driver.get(URL);
        verifyHeaderPage();
        getSignInPageTitle();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        return new DashboardPage(driver);
    }
    public void loginInvalidEmail(String email, String password){
        driver.get(URL);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        verifyErrorMessage();
    }

}