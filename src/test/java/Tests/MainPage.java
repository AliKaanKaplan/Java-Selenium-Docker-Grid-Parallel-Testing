package Tests;

import Manager.DriverManager;
import org.testng.annotations.*;
import pages.MainPageEl;

import java.net.MalformedURLException;

public class MainPage extends DriverManager {
    MainPageEl mainPageEl = new MainPageEl();

    @Parameters("browser")
    @BeforeClass
    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @Test
    void CheckLoginButton() throws InterruptedException {
        mainPageEl.verifyLoginButton(driver);
    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }
}
