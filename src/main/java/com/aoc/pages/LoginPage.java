package com.aoc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aoc.base.TestBase;

public class LoginPage extends TestBase {

    //Page Factory :
    @FindBy(name = "user-name")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(className = "submit-button")
    WebElement loginBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addOneProduct;
    @FindBy(className = "shopping_cart_link")
    WebElement CheckoutButton;
    @FindBy(css ="[name='remove-test.allthethings()-t-shirt-(red)']")
    WebElement RemoveProduct;
    @FindBy(name = "continue-shopping")
    WebElement ContinueShop;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement AddTheFirstProduct;
    @FindBy(className = "product_sort_container")
    WebElement SortingLowToHigh;
    @FindBy(className = "product_sort_container")
    WebElement SortingHighToLow;
    @FindBy(className = "product_sort_container")
    WebElement SortingByName;
    @FindBy(className = "product_sort_container")
    WebElement SortingByName2;
    @FindBy(id = "checkout")
    WebElement CheckoutIcon;
    @FindBy(id = "first-name")
    WebElement FirstName;
    @FindBy(id = "last-name")
    WebElement LastName;
    @FindBy(id ="postal-code")
    WebElement PostalCode;
    @FindBy(id = "continue")
    WebElement Continue;
    @FindBy(id = "cancel")
    WebElement CancelTheCheckOut;
    @FindBy(id = "finish")
    WebElement FinishOrder;
    @FindBy (id = "back-to-products")
    WebElement BackToHome;
    @FindBy(css = "#react-burger-menu-btn")
    WebElement MenuBar;
    @FindBy (xpath = "//*[@id=\"about_sidebar_link\"]")
    WebElement aboutPage;
    @FindBy(css = "[href='https://twitter.com/saucelabs']")
    WebElement twitterLink;
    @FindBy(css = "[href='https://www.facebook.com/saucelabs']")
    WebElement facebookLink;
    @FindBy(css = "[href='https://www.linkedin.com/company/sauce-labs/']")
    WebElement linkedInLink;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;


    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public void LoginToSwag(String un, String pw){
        username.sendKeys(un);
        password.sendKeys(pw);
        loginBtn.click();
    }
    public void TheProducts(String ct) {
        addOneProduct.click();
    }
    public void CartShop(String co) {
        CheckoutButton.click();
    }
    public boolean Checkout() {
        return CheckoutButton.isDisplayed();
    }
    public static void scrollPageDown(WebDriver driver, int scrollPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scrollPixels + ")");
    }
    public void RemoveTheLastProduct(String RS){
        RemoveProduct.click();
    }
    public void ContinueShopping(String CS){
        ContinueShop.click();
    }
    public static void scrollPageUp(WebDriver driver, int scrollPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scrollPixels + ")");
    }
    public void AddTheProductOneMoreTime(String Pro){
        AddTheFirstProduct.click();
    }
    public void FilterByPriceLowToHigh(String pe){
        SortingLowToHigh.click();
    }
    public void FilterByPriceHighToLow(String pe2){
        SortingHighToLow.click();
    }
    public void FilterByName(String AZ){
        SortingByName.click();
    }
    public void CheckoutPro(String PS){
        CheckoutIcon.click();
    }
    public void homePage(){
        driver.get("https://www.saucedemo.com");
    }
    public void Information(String Info){
        FirstName.sendKeys("Ibtesam");
        LastName.sendKeys("Omeir");
        PostalCode.sendKeys("44586h");
        Continue.click();
    }
    public void Cancel(String CL){
        CancelTheCheckOut.click();
    }
    public void ReturnToSwagPage(){
        driver.navigate().back();
    }
    public void OrderComplete(String OC){
        FinishOrder.click();
    }
    public void Menu(String MB) {
        MenuBar.click();
    }
    public void BackToHomePage( String BH){
        BackToHome.click();
    }
    public void twitterPage(){
         twitterLink.click();
    }
    public void faceBookPage(){
        facebookLink.click();
    }
    public void linkedInPage(){
        linkedInLink.click();
    }
    public void goToAboutPage() {
        aboutPage.click();
        driver.navigate().back();
    }
    public void logOut_icon(){
        logout.click();
    }
}