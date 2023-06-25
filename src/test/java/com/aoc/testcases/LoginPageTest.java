package com.aoc.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aoc.base.TestBase;
import com.aoc.pages.LoginPage;
import java.util.List;
import java.util.Set;

import static com.aoc.pages.LoginPage.scrollPageDown;
import static com.aoc.pages.LoginPage.scrollPageUp;

public class LoginPageTest extends TestBase {
    LoginPage Login;

    /* public LoginPageTest() {
         super();
     }*/
    @BeforeMethod
    public void setUpHomePage() {
        Login = new LoginPage();
    }

    @Test(priority = 1, description = "Validate title")
    public void loginPageTitleTest() throws InterruptedException {
        String title = Login.validateLoginPageTitle();
        Assert.assertEquals(title, "Swag Labs");
        System.out.println("The title is " + title);
    }

    @Test(priority = 2, description = "Login")
    public void LoginTest() {
        Login.LoginToSwag(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 3, description = "Add The first product to cart")
    public void AddOneProductToCard() {
        Login.TheProducts(prop.getProperty("Cart"));
    }

    @Test(priority = 4, description = "get Product size")
    public void SizeAndNumberOfProduct() {
        List<WebElement> Products = driver.findElements(By.className("inventory_item"));
        for (int i = 0; i < Products.size(); i++) {
            System.out.println("List of product = " + Products.get(i).getText());
            System.out.println("number of product=" + Products.size());
        }
    }

    @Test(priority = 5, description = "ClickOnAddToCart")
    public void AddAllProducts() throws InterruptedException {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        for (WebElement product : products) {
            Thread.sleep(2000);
            WebElement addToCartButton = product.findElement(By.className("btn"));
            addToCartButton.click();
        }
    }

    @Test(priority = 6, description = "ClickOnCheckOutIcon")
    public void CheckOut() throws InterruptedException {
        Thread.sleep(2000);
        Login.CartShop(prop.getProperty("co"));
    }

    @Test(priority = 7, description = "Checkout icon is displayed")
    public void CheckOutIconTest() {
        boolean Checkout = Login.Checkout();
        if (Checkout) {
            System.out.println("The CheckOut button is appear");
        } else
            Assert.fail("The CheckOut button is not appear");
    }

    @Test(priority = 8, description = "Scroll To the last Product And click on product to remove it")
    public void Scroll() throws InterruptedException {
        Thread.sleep(2000);
        scrollPageDown(driver, 650);
    }

    @Test(priority = 9, description = "Remove The last Product")
    public void Remove() {
        Login.RemoveTheLastProduct(prop.getProperty("RE"));
    }

    @Test(priority = 11, description = "Back to shopping page")
    public void BackToShopping() {
        Login.ContinueShopping(prop.getProperty("Shopping"));
    }

    @Test(priority = 12, description = "Scroll To the last Product And click on product to remove it")
    public void ScrollUP() throws InterruptedException {
        Thread.sleep(2000);
        scrollPageUp(driver, -650);
    }

    @Test(priority = 13, description = "The first product one more time")
    public void TheFirstProduct() {
        Login.AddTheProductOneMoreTime(prop.getProperty("Pro"));
    }

    @Test(priority = 14, description = "Sorting the product by price from low to high")
    public void PriceSort() {
        Login.FilterByPriceLowToHigh(prop.getProperty("Price"));
        Select LowToHigh = new Select(driver.findElement(By.className("product_sort_container")));
        LowToHigh.selectByVisibleText("Price (low to high)");
    }

    @Test(priority = 15, description = "Sorting the product by price from high to low")
    public void PriceSort2() throws InterruptedException {
        Thread.sleep(4000);
        Login.FilterByPriceHighToLow(prop.getProperty("pr"));
        Select PriceHighToLow = new Select(driver.findElement(By.className("product_sort_container")));
        PriceHighToLow.selectByVisibleText("Price (high to low)");
    }

    @Test(priority = 16, description = "Sorting the product by Name from A to Z")
    public void NameSort() throws InterruptedException {
        Thread.sleep(4000);
        Login.FilterByName(prop.getProperty("pr"));
        Select ByName = new Select(driver.findElement(By.className("product_sort_container")));
        ByName.selectByVisibleText("Name (A to Z)");
    }

    @Test(priority = 17, description = "Sorting the product by Name from A to Z")
    public void NameSort2() throws InterruptedException {
        Thread.sleep(4000);
        Login.FilterByName(prop.getProperty("pr"));
        Select ByName = new Select(driver.findElement(By.className("product_sort_container")));
        ByName.selectByVisibleText("Name (Z to A)");
    }

    @Test(priority = 18, description = "products Cart")
    public void CheckOutItems() {
        Login.CartShop(prop.getProperty("Out"));
    }

    @Test(priority = 19, description = "Check Out")
    public void CheckoutPro() throws InterruptedException {
        Thread.sleep(2000);
        Login.CheckoutPro(prop.getProperty("Pros"));
    }

    @Test(priority = 20, description = "Scroll the ine up")
    public void ScrollUp2() throws InterruptedException {
        Thread.sleep(2000);
        scrollPageUp(driver, -650);
    }

    @Test(priority = 21, description = "Send the Info")
    public void CheckOutInfo() throws InterruptedException {
        Thread.sleep(2000);
        Login.Information(prop.getProperty("info"));
        scrollPageDown(driver, 650);
    }

    @Test(priority = 22, description = "Cancel the order")
    public void CancelOrder() throws InterruptedException {
        scrollPageDown(driver, 650);
        Thread.sleep(4000);
        Login.Cancel(prop.getProperty("cl"));
    }

    @Test(priority = 23, description = "Forward to CheckoutPage")
    public void OutTheItems() throws InterruptedException {
        Thread.sleep(4000);
        Login.ReturnToSwagPage();
    }

    @Test(priority = 24, description = "Validate if order is completed")
    public void CompleteOrder() {
        Login.OrderComplete(prop.getProperty("Comp"));
    }

    @Test(priority = 25, description = "get the Complete order statements")
    public void CompleteOrder2() {
        WebElement Statement = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        System.out.println("The first complete statement = " + Statement.getText());
        WebElement Statement2 = driver.findElement(By.className("complete-text"));
        System.out.println("The second complete statement = " + Statement2.getText());
    }

    @Test(priority = 26, description = "Back to Home page")
    public void BackIcon() throws InterruptedException {
        Thread.sleep(3000);
        Login.BackToHomePage(prop.getProperty("back h"));
    }

    @Test(priority = 27, description = "Check if Reset-App page opened")
    public void TwitterPage() throws InterruptedException {
        Thread.sleep(5000);
        Login.twitterPage();
    }

    @Test(priority = 28, description = " Go to about page")
    public void WindowHandle() throws InterruptedException {
        Thread.sleep(3000);
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Login.homePage();
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        for (String window : allWindows) {
            if (!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(parent);
                System.out.println(driver.getTitle());
            }
        }
    }

    @Test(priority = 29, description = "Login one more time")
    public void loginToSwag2() {
        Login.LoginToSwag(prop.getProperty("username"), prop.getProperty("password"));
        scrollPageDown(driver, 650);
    }

    @Test(priority = 30, description = "Check if Reset-App page opened")
    public void FacebookPage() throws InterruptedException {
        Thread.sleep(5000);
        Login.faceBookPage();
    }

    @Test(priority = 31, description = " Go to about page")
    public void windowHandles() throws InterruptedException {
        Thread.sleep(3000);
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Login.homePage();
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        for (String window : allWindows) {
            if (!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(parent);
                System.out.println(driver.getTitle());
            }
        }
    }

    @Test(priority = 32, description = "Login one more time")
    public void loginToSwag3() {
        Login.LoginToSwag(prop.getProperty("username"), prop.getProperty("password"));
        scrollPageDown(driver, 650);
    }

    @Test(priority = 33, description = "")
    public void LinkedinPage() throws InterruptedException {
        Thread.sleep(5000);
        Login.linkedInPage();
    }

    @Test(priority = 34, description = "")
    public void windowHandle2() throws InterruptedException {
        Thread.sleep(3000);
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Login.homePage();
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        for (String window : allWindows) {
            if (!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(parent);
                System.out.println(driver.getTitle());
            }
        }
    }

    @Test(priority = 35, description = "Login one more time")
    public void loginToSwag4() {
        Login.LoginToSwag(prop.getProperty("username"), prop.getProperty("password"));
        scrollPageUp(driver, -650);

    }

    @Test(priority = 36, description = "Click on The menu bar")
    public void MenuBar() throws InterruptedException {
        Thread.sleep(3000);
        Login.Menu(prop.getProperty("MB"));
    }

    @Test(priority = 37, description = " Go to about page")
    public void aboutPage() throws InterruptedException {
        Thread.sleep(3000);
        Login.goToAboutPage();
    }
    @Test(priority = 39,description = "log out")
    public void logOut() throws InterruptedException {
        Thread.sleep(5000);
        Login.logOut_icon();
    }*/
}


