import com.epam.bo.LoginBO;
import com.epam.drivers.BrowserType;
import com.epam.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test()
public class ParrallelExecutionTest {
    @Parameters("browser")
    public void test1(String browser) {

        if (browser.equalsIgnoreCase("Firefox")) {

            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");

            WebDriver driver = new FirefoxDriver();

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
