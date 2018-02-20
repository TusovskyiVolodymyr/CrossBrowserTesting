import com.epam.bo.LoginBO;
import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AccessSpeedTest {

    private WebDriver driver;

    private LoginBO loginBO;

    @BeforeMethod
    public void before() {
        driver = DriverFactory.getWebDriver(BrowserType.OPERA);
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
