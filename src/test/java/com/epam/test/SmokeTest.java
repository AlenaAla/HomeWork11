package com.epam.test;

import com.epam.taf.model.User;
import com.epam.taf.service.UserDataGenerator;
import com.epam.taf.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;



public class SmokeTest extends CommonConditions {

    private static final String FULL_NAME = "Clerk Court";


    @Test
    public void userCanLogin() {
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        Assert.assertTrue(Steps.isUserLoggedIn(FULL_NAME));
    }
}
