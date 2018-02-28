import com.epam.bo.LoginBO;
import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AccessSpeedTest {

    private WebDriver driver;

    private LoginBO loginBO;

    @Parameters("browser")
    @BeforeMethod
    public void before(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            driver = DriverFactory.getWebDriver(BrowserType.CHROME);
        }else if (browser.equalsIgnoreCase("opera")){
            driver = DriverFactory.getWebDriver(BrowserType.OPERA);
        }else if (browser.equalsIgnoreCase("ie")){
            driver = DriverFactory.getWebDriver(BrowserType.IE);
        }
        loginBO = new LoginBO();
    }

    @org.testng.annotations.Test()
    public void test() {
        driver.get("http://the-internet.herokuapp.com/login");
        loginBO.checkLocatorsSpeed();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }
}
