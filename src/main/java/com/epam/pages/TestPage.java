package com.epam.pages;

import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class TestPage {

    private WebDriver driver = DriverFactory.getWebDriver(BrowserType.CHROME);

    private  WebElement findByName = driver.findElement(By.name("test_name"));

    private WebElement findById = driver.findElement(By.id("test_id"));

    private WebElement findByClassName = driver.findElement(By.className("test_class_name"));

    private WebElement findByCss = driver.findElement(By.cssSelector("#test_id"));

    private WebElement findByXPath = driver.findElement(By.xpath("//*[@class='test_class_name']"));

    @CacheLookup
    private WebElement findByCashedXPath = driver.findElement(By.xpath("//*[@class='test_class_name']"));

    public void findBy(){

    }
}
