package com.epam.taf.util;

import org.apache.commons.lang.RandomStringUtils;

public class StringUtils {
    public static String generateRandomString()
    {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
