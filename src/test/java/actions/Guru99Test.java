package actions;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class Guru99Test {
    /*
        1. go to https://demo.guru99.com/test/drag_drop.html
        2. drag 5000 and drop it under "Debit card amount"
        3. verify Debit Movement = 5000
     */

    public static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = Driver.getDriver();
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }


    @Test
    public void testDebitMovement(){
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement draggable5000 = driver.findElement(By.xpath("(//li[@data-id='2'])[1]"));
        WebElement targetPlace = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable5000, targetPlace).perform();

        String debitMovement = driver.findElement(By.xpath("(//div[@id='bal3']//td)[1]")).getText();
        String debitValue = driver.findElement(By.xpath("(//div[@id='bal3']//td)[2]")).getText();

        Assert.assertEquals("Debit Movement", debitMovement);
        Assert.assertEquals("5000", debitValue);

    }

    @Test
    public void testDebit(){
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement draggable5000 = driver.findElement(By.xpath("(//li[@data-id='2'])[1]"));
        WebElement targetPlace = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(draggable5000)
                .clickAndHold()
                .moveToElement(targetPlace)
                .release()
                .build()
                .perform();

    }




}
