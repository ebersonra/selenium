package com.selenium.marionette.system.test.util;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class SeleniumDataProvider extends SeleniumCommonValue {

    @DataProvider(name = "SeleniumDataProvider")
    public Object[][] getDataFromDataProvider(ITestContext context){

        Object[][] groupsArray = null;

        for(String group : context.getIncludedGroups()){
            if(group.equalsIgnoreCase("searchGoogle")){

                groupsArray = new Object[][]{
                        {"Selenium"}
                };
                break;
            }
        }

        return groupsArray;
    }
}