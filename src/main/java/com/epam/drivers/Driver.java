package com.epam.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private Driver() {
    }
    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver instance;
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        instance = new ChromeDriver();
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }
    public static void quit() {
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}
