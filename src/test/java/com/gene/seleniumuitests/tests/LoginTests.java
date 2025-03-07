package com.gene.seleniumuitests.tests;

import com.gene.seleniumuitests.pageobjects.InventoryPage;
import com.gene.seleniumuitests.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginFunctionality() {
        logger.info("Starting login functionality tests");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.visit();
        InventoryPage inventoryPage = loginpage.executeLogin("standard_user", "secret_sauce");

        logger.info("Verifying successful login to inventory page");
        Assert.assertEquals(inventoryPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        logger.info("Verifying that Product text is displayed");
        Assert.assertTrue(inventoryPage.IsProductsDisplayed(), "Product is not displayed");
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"WrongUsername", "WrongPassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void negativeTestSet(String username, String password, String expectedMessage) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.visit();
        loginpage.executeLogin(username, password);
        logger.info("Verifying error message is displayed");
        Assert.assertEquals(loginpage.errorMessage(), expectedMessage, "Expected message not displayed");
    }

    @Test
    public void performanceGlitch(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.visit();
        InventoryPage inventoryPage = loginpage.executeLogin("performance_glitch_user", "secret_sauce");

        logger.info("Verifying successful login to inventory page");
        Assert.assertTrue(loginpage.urlToBe(),"Page is not loaded");

    }
}
