package com.epam.taf.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import static com.epam.taf.pages.CreateNewUserPage.URL;


public class HomePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='header-username']")
    public WebElement fullUserNameLabel;


    @FindBy(xpath = "//a[@href='/ctrack/menu.do?menuHeaderID=4']")
    public WebElement administrativeTopMenu;


    @FindBy(xpath = "//a[@href='/ctrack/admin/menuUserAdmin.jsp?action=readonly'][@onclick='menuHeaderClose();']")
    public WebElement userAdminMenuUnderTopMenu;


    public HomePage() {
        super();
    }

    public String getLoggedInUserName() {
        return fullUserNameLabel.getText();
    }
    public void openPage() {
        driver.get(URL);
        logger.info("Login page opened");
    }
}



