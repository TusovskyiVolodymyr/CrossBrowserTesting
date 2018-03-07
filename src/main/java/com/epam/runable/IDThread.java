package com.epam.runable;

import com.epam.drivers.BrowserType;
import com.epam.drivers.Driver;
import com.epam.drivers.DriverFactory;
import com.epam.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IDThread extends Thread {
    private WebDriver driver;

    public IDThread(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        LoginPage loginPage = new LoginPage(driver);
            loginPage.findBy("ID", By.id("username"));
    }
}
