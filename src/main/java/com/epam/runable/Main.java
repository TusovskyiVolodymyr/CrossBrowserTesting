package com.epam.runable;

import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver(BrowserType.CHROME);
        driver.get("http://the-internet.herokuapp.com/login");
        IDThread idThread = new IDThread(driver);
        idThread.start();
        NameThread nameThread = new NameThread(driver);
        nameThread.start();
        CSSThread cssThread = new CSSThread(driver);
        cssThread.start();
        XPathThread xPathThread = new XPathThread(driver);
        xPathThread.start();
    }
}
