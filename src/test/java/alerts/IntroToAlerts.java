package alerts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class IntroToAlerts {
    /*
    1. go to https://demo.guru99.com/test/delete_customer.php
    2. enter customer id
    3. click on submit button
    4. get alert message and print it
    5. accept alert window
    6. get alert message from new alert window and print it
    7. accept alert window
     */

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement customerIdField = driver.findElement(By.name("cusid"));
        customerIdField.sendKeys("24341");

        WebElement submitButton = driver.findElement(By.cssSelector("input[name=submit]"));
        submitButton.click();

        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println(alertMessage1);

        driver.switchTo().alert().accept();

        /*
        wait until alert pops up
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);

        Assert.assertTrue(driver.getCurrentUrl().contains(".com"));

        driver.switchTo().alert().accept();
    }
}
