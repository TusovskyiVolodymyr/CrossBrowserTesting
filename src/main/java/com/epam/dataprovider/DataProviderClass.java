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

    @DataProvider(name = "Complicated")
    public static Object[][] complicated() {
        return new Object[][]{
//                {"NAME", By.name("test_name")},
//                {"ID", By.id("test_id")},
//                {"CLASSNAME", By.className("test_class_name")},
//                {"CSS", By.cssSelector("#test_id")},
                {"XPATH", By.xpath("//*[@class='test_class_name']")}
        };
    }

}
