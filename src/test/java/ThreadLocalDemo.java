import com.epam.ResultsCollector;
import com.epam.dataprovider.DataProviderClass;
import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadLocalDemo {
    //    private static String webURL = "http://the-internet.herokuapp.com/login";
    private static String webURL = "file:///C:\\Users\\Volodymyr_Tysovskyi\\Desktop\\New folder\\test.html";

    private final static int repeatCount = 1;

    private final static List<ResultsCollector> results= new ArrayList<>();

    private WebDriver driver;
//    @Parameters("browser")
//    @BeforeMethod
//    public void setUp(String browser){
//        if (browser.equalsIgnoreCase("Chrome"))
//
//    }

    //    @Test (dataProvider = "Info")
    @Test (dataProviderClass = DataProviderClass.class, dataProvider = "Complicated")
    public void testFindBy(String locatorType, By locator) {
        long beginOfCount;
        long endOfCount;
        long times = 0;

        WebDriver driver = DriverFactory.getWebDriver(BrowserType.IE);

        invokeBrowser(webURL);
        for (int i = 0; i < repeatCount; i++) {
            beginOfCount = System.currentTimeMillis();
            driver.findElement(locator);
            endOfCount = System.currentTimeMillis();
            driver.get(driver.getCurrentUrl());
            times = times + (endOfCount - beginOfCount);
        }
        String time = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(times/repeatCount));
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Time spend on finding elements by "+locatorType+": "+time);
        results.add(new ResultsCollector(browserName, locatorType, time));

    }

    private void invokeBrowser(String url) {
        DriverFactory.getWebDriver(BrowserType.IE).get(url);
    }

    @AfterSuite
    public void finishResults(){
        System.out.println("FINAL RESULTS");
        for(ResultsCollector item : results){
            System.out.println("/*************************/");
            item.printResult();
        }
    }

    private void clearCacheChrome(WebDriver driver){
        driver.get("chrome://settings/clearBrowserData");
    }

    private void deleteCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }

}
