package com.gene.seleniumuitests.tests;

import com.gene.seleniumuitests.pageobjects.InventoryPage;
import com.gene.seleniumuitests.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginFunctionality(){
        logger.info("Starting login functionality tests");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.visit();
        InventoryPage inventoryPage =  loginpage.executeLogin("standard_user", "secret_sauce");

        logger.info("Verifying successful login to inventory page");
        Assert.assertEquals(inventoryPage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        logger.info("Verifying that Product text is displayed");
        Assert.assertTrue(inventoryPage.IsProductsDisplayed(),"Product is not displayed");



    }

}
