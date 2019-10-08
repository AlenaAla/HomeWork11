package com.epam.taf.steps;

//import UserAdminPage.UserAdmin;

import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.model.User;
import com.epam.taf.pages.*;
import com.epam.taf.service.UserDataGenerator;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class StepsDef {

    private static final Logger logger = LogManager.getRootLogger();

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }


    @When("^I login in CMS$")
    public void loginCMS() {
        User defaultUser = UserDataGenerator.createDefaultUser();
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        if (DriverSingleton.getDriver().getTitle().contains("C-Track")) {
            loginPage.loginField.sendKeys(defaultUser.getUsername());
            loginPage.passwordField.sendKeys(defaultUser.getPassword());
            loginPage.loginButton.click();
            logger.info("Login is performing");
        }
    }


    @When("^I open Create User Page$")
    public void openCreateUserPage() {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        createNewUserPage.openPage();
    }


    @When("^I fill in Username field with \"([^\"]*)\" value$")
    public void fillUsername(String testUsername) {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        createNewUserPage.username.sendKeys(testUsername);
    }


    @When("^I click Save$")
    public void clickSave() {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        createNewUserPage.saveUserButton.click();
        logger.info("clicking Save button");
    }

    @Then("^Validation message \"([^\"]*)\" appears$")
    public void verifyUserNameValidation(String expectedValidationMessage) {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        logger.info("waiting for Validation Message");
        String actualValidationMessage = createNewUserPage.getValidationMessage();
        System.out.println("actualValidationMessage is " + actualValidationMessage);
        Assert.assertEquals(actualValidationMessage, expectedValidationMessage, "Actual validation message does not match to Expected one");
    }
}















