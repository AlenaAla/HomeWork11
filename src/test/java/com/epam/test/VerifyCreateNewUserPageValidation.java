package com.epam.test;

import com.epam.taf.model.User;
import com.epam.taf.service.UserDataGenerator;
import com.epam.taf.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyCreateNewUserPageValidation extends CommonConditions {

    private static final String TEST_USERNAME1 = "   ";
    private static final String TEST_USERNAME2 = "clerk1";

    private static final String VALIDATION_MESSAGE1 = "Username is required.";
    private static final String VALIDATION_MESSAGE2 = "The User Name you have entered already exists!";

    @Test
    public void verifyExistingUserNameValidation() {
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        Steps.navigateToCreateNewUserPageByLink();
        Steps.fillInUsernameField(TEST_USERNAME2);
        Steps.saveUser();
        //Steps.isValidationMessageReturned(VALIDATION_MESSAGE2);
        Assert.assertTrue(Steps.isValidationMessageReturned(VALIDATION_MESSAGE2));
    }

    @Test
    public void verifyEmptyUserNameValidation() {
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        Steps.navigateToCreateNewUserPageByLink();
        Steps.fillInUsernameField(TEST_USERNAME1);
        Steps.saveUser();
        System.out.println("Boolean result is " + Steps.isValidationMessageReturned(VALIDATION_MESSAGE1));
        Assert.assertTrue(Steps.isValidationMessageReturned(VALIDATION_MESSAGE1));
    }

}
