package com.epam.taf.steps;


import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.model.User;
import com.epam.taf.pages.CreateNewUserPage;
import com.epam.taf.pages.LoginPage;
import com.epam.taf.pages.ManageUserPage;
import com.epam.taf.service.UserDataGenerator;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    @When("^I fill in required fields on Create New User form with random user values$")
    public static void createNewUser() {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        createNewUserPage.openPage();
        logger.info("Opening Create New App User page");

        User randomUser = UserDataGenerator.createRandomUser();

        new Actions(DriverSingleton.getDriver()).sendKeys(createNewUserPage.password, randomUser.getPassword()).sendKeys(createNewUserPage.firstName, randomUser.getFirstName()).sendKeys(createNewUserPage.lastName, randomUser.getLastName()).build().perform();
        logger.info("Filling in Password, Fisrt Name, Last Name fields");
        new Select(createNewUserPage.loginPageDropdown).selectByVisibleText("Main Case Search");
        logger.info("Selecting value for  Login dropdown");
        List<WebElement> courtsOptions = new Select(createNewUserPage.courts).getOptions();

        ArrayList<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Court of Appeals");
        expectedOptions.add("Supreme Court");
        Actions actions = new Actions(DriverSingleton.getDriver());

        for (int i = 0; i < courtsOptions.size(); i++) {
            WebElement optionElement = courtsOptions.get(i);
            String actualOption = optionElement.getText();
            if (expectedOptions.contains(actualOption)) {
                actions.keyDown(Keys.CONTROL).click(optionElement).keyUp(Keys.CONTROL);
            }
        }

        actions.build().perform();
        logger.info("Selecting both options from Courts dropdown");
        createNewUserPage.username.sendKeys(randomUser.getUsername());
        logger.info("Filling in UserName fields");
        createNewUserPage.email.sendKeys(randomUser.getUsername() + "@thomsonreuters.com");
        logger.info("Filling in email fields");}

    @Then ("^New User with supplied username created$")
    public static boolean verifyUserName() {
        ManageUserPage manageUserPage = new ManageUserPage();
        User randomUser = UserDataGenerator.LAST_GENERATED_USER;
        String actualUserName = manageUserPage.getUserName();
        System.out.println(actualUserName);
        logger.info("Getting actual UserName");
        return actualUserName.equals(randomUser.getUsername());
    }


}















