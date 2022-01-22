package Manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public WebDriver driver;

    public void setDriver(String testBrowser) throws MalformedURLException {
        switch (testBrowser) {
            case "grid-firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                System.out.println("***** Selenium Grid Firefox *****");
                break;
            }
            case "grid-chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-setuid-sandbox");
                chromeOptions.addArguments("--remote-debugging-port=9222");
                chromeOptions.addArguments("--disable-dev-shm-using");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("disable-infobars");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                System.out.println("***** Selenium Grid Chrome *****");
                break;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("***** Browser is firefox *****");
                break;
            }
            case "firefox-headless": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("***** Browser is firefox *****");
                break;
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("***** Browser is chrome *****");
                break;
            }
            case "chrome-headless": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("***** Browser is chrome-headless *****");
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("***** Browser is chrome-bonigarcia *****");
                break;
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
