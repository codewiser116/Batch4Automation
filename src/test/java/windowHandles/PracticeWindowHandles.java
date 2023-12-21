package windowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.Set;

public class PracticeWindowHandles {
    /*
    1. go to https://www.saucedemo.com/
    2. login as standard user
    3. store window handle of main page in String
    4. click on Twitter icon, store window handle of Twitter page, verify url
    5. click on Facebook icon, store window handle of Facebook page, verify url
    6. click on Linkedin icon, store window handle of Linkedin page, verify url
    7.

    BREAK UNTIL 8:40 PM
     */

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String homePageWindowHandle = driver.getWindowHandle();

        System.out.println(driver.getCurrentUrl());

        WebElement twitter = driver.findElement(By.linkText("Twitter"));
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        WebElement linkedin = driver.findElement(By.linkText("LinkedIn"));

        verifySocialMedia(twitter, driver, homePageWindowHandle);
        verifySocialMedia(facebook, driver, homePageWindowHandle);
        verifySocialMedia(linkedin, driver, homePageWindowHandle);
    }

    public static void verifySocialMedia(WebElement socialMediaButton, WebDriver driver, String homePageWindowHandle){

        //=========================================================
        socialMediaButton.click();

        for (String windowHandle : driver.getWindowHandles()){
            if (!windowHandle.equals(homePageWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println("URL: " + driver.getCurrentUrl());

        //close twitter page
        driver.close();

        // and go back to home page
        driver.switchTo().window(homePageWindowHandle);
        //=========================================================
    }








}
