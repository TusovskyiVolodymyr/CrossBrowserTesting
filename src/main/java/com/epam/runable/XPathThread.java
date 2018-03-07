package com.epam.runable;

import com.epam.drivers.BrowserType;
import com.epam.drivers.Driver;
import com.epam.drivers.DriverFactory;
import com.epam.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathThread extends Thread {

    private WebDriver driver;

    public XPathThread(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        LoginPage loginPage = new LoginPage(driver);
            loginPage.findBy("XPATH", By.xpath("//input[@name='username']"));
    }
}
