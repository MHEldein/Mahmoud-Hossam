package Base;

import PagesLibrary.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.security.PublicKey;

public class BaseTest {

    private WebDriver driver;
    protected SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
