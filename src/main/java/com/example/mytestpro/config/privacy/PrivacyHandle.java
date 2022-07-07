package com.example.mytestpro.config.privacy;


import org.apache.commons.lang3.StringUtils;

public class PrivacyHandle {
    public static String handle(String value, int pre, int suf, String character) {
        int length = value.length();
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        if (pre < 0 || suf < 0 || pre >= length || suf >= length) {
            throw new IndexOutOfBoundsException("error");
        }
        return value.substring(0, pre) + StringUtils.repeat(character, length - pre - suf) + value.substring(length - suf);
    }
}
