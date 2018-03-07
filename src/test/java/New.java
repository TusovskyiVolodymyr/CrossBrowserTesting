import com.epam.dataprovider.DataProviderClass;
import com.epam.drivers.BrowserType;
import com.epam.drivers.Driver;
import com.epam.drivers.DriverFactory;
import com.epam.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class New {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        driver = Driver.getWebDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://the-internet.herokuapp.com/login");
}

    @Test
    public void test() throws InterruptedException {
        loginPage.findBy("CSS", By.cssSelector("#username"));
    }

    @Test
    public void test2() throws InterruptedException {
        loginPage.findBy("ID", By.id("username"));
    }

    @Test
    public void test3() throws InterruptedException {
        loginPage.findBy("NAME", By.name("username"));
    }

    @Test
    public void test4() throws InterruptedException {
        loginPage.findBy("XPATH", By.xpath("//input[@name='username']"));
    }




    @AfterTest
    public void tearDown(){
        Driver.quit();
    }
}
