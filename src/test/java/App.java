import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.List;

public class App {

    WebDriver driver;

    @BeforeSuite
    void launchBrowser(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "user.dir"+"/chromedriver.exe");
    }

    @Test
    void openGoogle(){
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "openGoogle")
    void googleSearch(){
        WebElement element = driver.findElement(By.xpath("//*[@type=\"text\" and @title=\"Search\"]"));
        element.sendKeys("viu",Keys.ENTER);
    }

    @Test
    void clickFirstResult(){
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks);
    }
}
