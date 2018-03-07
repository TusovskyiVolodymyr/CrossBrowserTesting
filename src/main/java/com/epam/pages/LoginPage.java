package com.epam.pages;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.epam.util.MetricsUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginPage {

    private MetricsUtil metricsUtil = new MetricsUtil();

    private final MetricRegistry metrics = new MetricRegistry();

    private final Meter requests = metrics.meter("requests");

    private final static Logger logger = Logger.getLogger(LoginPO.class);

    private volatile int BOUND = 100;

    private int count;

    private WebDriver driver;

    @CacheLookup
    private WebElement element;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private long endOfCount = 0;
    private long totalCount = 0;

    public void findBy(String locatorName, By by) {
        for (int i = 0; i < BOUND; i++) {
            count++;
            long beginOfCount = System.currentTimeMillis();
            metricsUtil.startTimer();
            driver.findElement((by));
            metricsUtil.stopTimer();
            endOfCount = System.currentTimeMillis() - beginOfCount;
//            driver.navigate().refresh();
            System.out.println(Thread.currentThread());
            totalCount += endOfCount;
        }
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(totalCount));
        logger.info(String.format("Time spend on finding elements by %s: %s", locatorName, time));
        System.out.println(count);
        metricsUtil.reportMetrics();
    }
}
