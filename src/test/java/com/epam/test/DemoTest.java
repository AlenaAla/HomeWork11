package com.epam.test;

import com.epam.taf.model.User;
import com.epam.taf.service.UserDataGenerator;
import com.epam.taf.steps.Steps;
import com.epam.taf.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;



public class DemoTest extends CommonConditions{

    private static final String FULL_NAME = "Clerk Court";
    private static final String USER_ADMIN_URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/admin/menuUserAdmin.jsp?action=readonly";

    

    @Test
    public void userCanLogin() {
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        Assert.assertTrue(Steps.isUserLoggedIn(FULL_NAME));
    }



    @Test
    public void userCanReachToEntityManagementViaTopMenu(){
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        Steps.navigateToEntityManagementViaTopMenu();
       // Assert.assertTrue(Steps.isUserOnUserAdminScreen(USER_ADMIN_URL));
    }

    @Test
    public void userCanBeCreated(){
        User testUser = UserDataGenerator.createDefaultUser();
        Steps.loginCMS(testUser);
        String randomName = StringUtils.generateRandomString();
        User randomUser = UserDataGenerator.createRandomUser();
        Steps.createNewUser(randomUser);
        String b = randomUser.getUsername();
        boolean a = Steps.verifyUserName(b);
        Assert.assertTrue(a);

    }


}
