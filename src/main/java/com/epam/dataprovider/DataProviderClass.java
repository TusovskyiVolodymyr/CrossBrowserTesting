package com.epam.dataprovider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "Info")
    public static Object[][] info() {
        return new Object[][]{
                {"CSS", By.cssSelector("#username")},
                {"XPATH", By.xpath("//input[@name='username']")}
        };
    }

    @DataProvider(name = "Complicated", parallel = true)
    public static Object[][] complicated() {
        return new Object[][]{
                {"NAME", By.name("username")},
                {"ID", By.id("username")},
//                {"CLASSNAME", By.className("username")},
                {"CSS", By.cssSelector("#username")},
                {"XPATH", By.xpath("//input[@name='username']")}
        };
    }

}
