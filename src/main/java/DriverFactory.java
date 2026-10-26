import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void init() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFirefox();
        } else
            initChrome();
        }


    public void initChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void initFirefox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    protected void before()  {
        init();
    }

    @Override
    protected void after() {
        driver.quit();
    }
}
