package com.selenium.marionette.common;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumMarionetteCaseFormat {

    public static String toLowerUnderscore(String upperCamel){
        return Stream.of(upperCamel.split("(?=[A-Z])"))
                .map(s -> s.toLowerCase())
                .collect(Collectors.joining("_"));
    }

    public static String toReplaceProtocolAndHostname(String valueToReplace) {
        return valueToReplace.substring(
                valueToReplace.indexOf("/images/"))
                .replace("/images/","");
    }
}
