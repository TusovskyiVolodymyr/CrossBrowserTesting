package com.epam.pages;

import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginPO {

    private final static Logger logger = Logger.getLogger(LoginPO.class);

    private final int BOUND = 1000;

    private WebDriver driver = DriverFactory.getWebDriver(BrowserType.CHROME);

    @FindBy(name = "username")
    private WebElement findByName;

    @FindBy(id = "username")
    private WebElement findById;

    @FindBy(css = "#username")
    private WebElement findByCSS;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement findByXPath;

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    private WebElement findByXPathCashed;


    public LoginPO() {
        PageFactory.initElements(driver, this);
    }

    public void findByName() {
        long beginOfCount = System.currentTimeMillis();
        for (int i = 0; i < BOUND; i++) {
            findByName.sendKeys("Text to submit");
            findByName.clear();
        }
        long endOfCount = System.currentTimeMillis();
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
        logger.info("Time spend on finding elements by name: "+time);
    }

    public void findById() {
        long beginOfCount = System.currentTimeMillis();
        for (int i = 0; i < BOUND; i++) {
            findById.sendKeys("Text to submit");
            findById.clear();
        }
        long endOfCount = System.currentTimeMillis();
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
        logger.info("Time spend on finding elements by ID: "+time);
    }

    public void findByCSS() {
        long beginOfCount = System.currentTimeMillis();
        for (int i = 0; i < BOUND; i++) {
            findByCSS.sendKeys("Text to submit");
            findByCSS.clear();
        }
        long endOfCount = System.currentTimeMillis();
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
        logger.info("Time spend on finding elements by CSS: "+time);
    }

    public void findByXPath() {
        long beginOfCount = System.currentTimeMillis();
        for (int i = 0; i < BOUND; i++) {
            findByXPath.sendKeys("Text to submit");
            findByXPath.clear();
        }
        long endOfCount = System.currentTimeMillis();
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
        logger.info("Time spend on finding elements by XPath: "+time);
    }

    public void findByXPathCashed() {
        long beginOfCount = System.currentTimeMillis();
        for (int i = 0; i < BOUND; i++) {
            findByXPathCashed.sendKeys("Text to submit");
            findByXPathCashed.clear();
        }
        long endOfCount = System.currentTimeMillis();
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
        logger.info("Time spend on finding elements by cashed XPath: "+time);
    }
}
