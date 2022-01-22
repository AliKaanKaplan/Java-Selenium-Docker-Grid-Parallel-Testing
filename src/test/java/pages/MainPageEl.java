package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPageEl {

    public  void verifyLoginButton(WebDriver driver) throws InterruptedException {
        driver.get("https://www.linkedin.com/");
        Thread.sleep(1000);
        WebElement searchElement = driver.findElement(By.cssSelector(".nav__button-secondary"));
        searchElement.click();
        WebElement loginButton = driver.findElement(By.cssSelector(".btn__primary--large"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

}
