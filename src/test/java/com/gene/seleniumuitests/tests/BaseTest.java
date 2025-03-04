package com.gene.seleniumuitests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){

        logger = Logger.getLogger(LoginTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running tests in: " + browser);

        switch (browser.toLowerCase()){
            case "chrome" :
                driver = new ChromeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            default:
                logger.warning("Configuration for " + browser + " is missing");
                driver = new ChromeDriver();
                break;
        }

    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
        logger.info("Ending tests");
    }

}
