import com.epam.drivers.BrowserType;
import com.epam.drivers.Driver;
import com.epam.drivers.DriverFactory;
import com.epam.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class New {

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getWebDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://the-internet.herokuapp.com/login");
}

    @Test
    public void test(){
        loginPage.findByName();
    }
    @Test
    public void test2(){
        loginPage.findById();
    }
//    @Test
//    public void test3(){
//        loginPage.findByName();
//    }
//    @Test
//    public void test4(){
//        loginPage.findByName();
//    }
//    @Test
//    public void test5(){
//        loginPage.findByName();
//    }

    @AfterMethod
    public void tearDown(){
        Driver.quit();
    }
}
