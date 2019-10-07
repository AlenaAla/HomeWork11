package com.epam.taf.service;

import com.epam.taf.model.User;
import com.epam.taf.util.StringUtils;

public class UserDataGenerator {


    public static final String USER_NAME = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";

    public static User createDefaultUser() {
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User createRandomUser() {
        return new User(StringUtils.generateRandomString(), StringUtils.generateRandomString(), StringUtils.generateRandomString(), StringUtils.generateRandomString());
    }

    public static User createUser(String name, String password) {
        return new User(name, password);
    }
}