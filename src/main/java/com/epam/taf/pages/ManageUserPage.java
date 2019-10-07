package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUserPage extends AbstractPage {

    @FindBy(xpath = "//table[@class='FormTable']//td[contains(text(), 'Username')]/../td[2]")
    private WebElement userNameLabel;

    public ManageUserPage() {
        super();
    }


    public String getUserName() {
        waitForElementVisible1(userNameLabel);

        return userNameLabel.getText();
    }
}
