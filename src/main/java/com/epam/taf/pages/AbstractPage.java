package com.epam.taf.pages;

import com.epam.taf.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriver driver;

    private static final int DEFAULT_TIMEOUT = 5;

    protected AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver, this);//from 2015
    }

    public void waitForElementVisible1(WebElement webElement) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    protected void waitForElementVisible2(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public String getPageURL() {
       return  this.driver.getCurrentUrl();
    }
}
