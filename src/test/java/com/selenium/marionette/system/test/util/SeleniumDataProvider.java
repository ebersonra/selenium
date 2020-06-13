package com.selenium.marionette.system.test.util;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class SeleniumDataProvider extends SeleniumCommonValue {

    @DataProvider(name = "SeleniumDataProvider")
    public Object[][] getDataFromDataProvider(ITestContext context){

        Object[][] groupsArray = null;

        for(String group : context.getIncludedGroups()){
            if(group.equalsIgnoreCase("consultByName")){

                groupsArray = new Object[][]{
                        {"Eberson Ramos", "11122233344"}
                };

                break;
            }else if(group.equalsIgnoreCase("editByName")){

                groupsArray = new Object[][]{
                        {"Eberson Ramos"}
                };
            }else if(group.contains("_noParameters")){

                groupsArray = new Object[][]{
                        {}
                };
                break;
            }
        }

        return groupsArray;
    }
}