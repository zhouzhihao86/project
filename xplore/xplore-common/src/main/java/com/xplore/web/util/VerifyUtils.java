package com.xplore.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhouzhihao on 2014/11/25.
 */
public class VerifyUtils {

    public static final Pattern REGEX_BASE_USERNAME = Pattern.compile("^\\w{5,20}$");

    public static final Pattern REGEX_MOBILE = Pattern.compile("1[34578]\\d{9}");

    public static final Pattern REGEX_EMAIL = Pattern.compile("(?=.{0,64})\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    public static boolean verify(String value, Pattern pattern) {

        if (org.springframework.util.StringUtils.isEmpty(value)) {
            return false;
        }

        Matcher cp = pattern.matcher(value);

        return cp.matches();
    }

}
