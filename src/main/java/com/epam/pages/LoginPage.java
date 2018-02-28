package com.epam.pages;

import com.codahale.metrics.*;
import com.epam.drivers.BrowserType;
import com.epam.drivers.Driver;
import com.epam.drivers.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final MetricRegistry metrics = new MetricRegistry();

    private final Meter requests = metrics.meter("requests");

    private final static Logger logger = Logger.getLogger(LoginPO.class);

    private final int BOUND = 10;

    private int count;

    private WebDriver driver = Driver.getWebDriver();

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


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public synchronized void findByName() {
        long beginOfCount ;
        long endOfCount = 0;
        long totalCount = 0;
        for (int i = 0; i < BOUND; i++) {
            count++;
            beginOfCount  = System.currentTimeMillis();
            Timer timer = metrics.timer("costly-operation.service-time");
            Timer.Context context = timer.time();
            driver.findElement(By.name("username"));
            context.stop();
            endOfCount = System.currentTimeMillis()-beginOfCount;
            driver.navigate().refresh();
        }
         totalCount +=endOfCount;
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(totalCount));
        logger.info("Time spend on finding elements by name: "+time);
        ConsoleReporter reporter = ConsoleReporter
                .forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(10, TimeUnit.SECONDS);
        reporter.report();
        final CsvReporter reporte2 = CsvReporter.forRegistry(metrics)
                .formatFor(Locale.US)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(new File("src\\main\\"));
        reporte2.start(1, TimeUnit.SECONDS);
        reporte2.report();
        System.out.println(count);
    }

    public synchronized void findById() {
        long beginOfCount ;
        long endOfCount = 0;
        long totalCount = 0;
        for (int i = 0; i < BOUND; i++) {
            count++;
            beginOfCount  = System.currentTimeMillis();
            Timer timer = metrics.timer("costly-operation.service-time");
            Timer.Context context = timer.time();
            driver.findElement(By.id("username"));
            context.stop();
            endOfCount = System.currentTimeMillis()-beginOfCount;
            driver.navigate().refresh();
        }
        totalCount +=endOfCount;
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(totalCount));
        logger.info("Time spend on finding elements by id: "+time);
        ConsoleReporter reporter = ConsoleReporter
                .forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(10, TimeUnit.SECONDS);
        reporter.report();
//        long beginOfCount = System.currentTimeMillis();
//        for (int i = 0; i < BOUND; i++) {
//            findById.sendKeys("Text to submit");
//            findById.clear();
//        }
//        long endOfCount = System.currentTimeMillis();
//        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(endOfCount - beginOfCount));
//        logger.info("Time spend on finding elements by ID: "+time);
        System.out.println(count);
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
