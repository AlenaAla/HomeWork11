package com.epam.taf.pages;

import com.epam.taf.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com";

    @FindBy(name = "userName")
    public WebElement loginField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(name = "submit")
    public WebElement loginButton;

    public LoginPage() {
        super();
    }

    public void openPage() {
        driver.get(URL);
        logger.info("Login page opened");
    }

    public void getPageTitle(){
        System.out.println(driver.getTitle());

    }

}
