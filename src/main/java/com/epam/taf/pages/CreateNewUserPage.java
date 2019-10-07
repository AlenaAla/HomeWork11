package com.epam.taf.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class CreateNewUserPage extends AbstractPage {
    public static final String URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/admin/appuser.do?action=create";

    @FindBy(id = "userNm")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "firstNm")
    public WebElement firstName;

    @FindBy(id = "lastNm")
    public WebElement lastName;

    @FindBy(name = "loginPage")
    public WebElement loginPageDropdown;

    @FindBy(name = "submitValue")
    public WebElement saveButton;

    @FindBy(name = "courtIDs")
    public WebElement courts;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//*[@value='Save']")
    public WebElement saveUserButton;

    @FindBy(xpath ="//div[@class='ui-state-error error-widget']/ul/li/a[contains(@onclick, 'userNm')]")

    private WebElement UsernameValidationMessage;


    public CreateNewUserPage() {
        super();
    }

    public void openPage() {
        driver.get(URL);
    }

    public String getValidationMessage() {
        waitForElementVisible1(UsernameValidationMessage);
        return UsernameValidationMessage.getText();
    }
}
