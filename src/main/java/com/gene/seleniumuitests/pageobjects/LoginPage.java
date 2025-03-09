package com.gene.seleniumuitests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInputLocator = By.id("user-name");
    private By passwordInputLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By errorMessageLocator = By.xpath("//div[contains(@class,'error-message-container')]/h3");



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void visit() {
        super.visit("https://www.saucedemo.com/");
    }

    public void enterUsername(String username){
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public InventoryPage executeLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage(driver);
    }

    public String errorMessage (){
        return getPageSource(errorMessageLocator);
    }

    public Boolean urlToBe (){
        return waitForUrl("https://www.saucedemo.com/inventory.html");
    }


}
