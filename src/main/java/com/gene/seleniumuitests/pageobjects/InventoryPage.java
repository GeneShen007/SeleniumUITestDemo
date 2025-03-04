package com.gene.seleniumuitests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    private By productText = By.className("title");

    public boolean IsProductsDisplayed(){
        return isDisplayed(productText);

    }
}
