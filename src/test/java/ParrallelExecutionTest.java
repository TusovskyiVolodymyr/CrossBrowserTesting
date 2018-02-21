import com.epam.bo.LoginBO;
import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

@Test()
public class ParrallelExecutionTest {
    @Parameters("browser")
    public void test1(String browser) {

        if (browser.equalsIgnoreCase("Opera")) {

            String operaBrowserLocation = "C:\\Program Files\\Opera\\51.0.2830.34\\opera.exe";
            System.setProperty("webdriver.opera.driver", "src\\main\\resources\\drivers\\operadriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary(operaBrowserLocation);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriver driver = new OperaDriver(capabilities);

            driver.manage().window().maximize();

            driver.get("http://www.facebook.com");

            driver.quit();

        } else if (browser.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("http://www.facebook.com");

            driver.quit();
        }
    }
}
