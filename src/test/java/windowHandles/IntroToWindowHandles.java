package windowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class IntroToWindowHandles {
    /*
    1. go to https://demoqa.com/browser-windows
    2. get its id - parents window handle
    3. click on new tab (https://demoqa.com/sample)
    3. print window handles
     */
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/browser-windows");

        String parentWindowHandle = driver.getWindowHandle();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        System.out.println(driver.getWindowHandle());

        Set<String> windows = driver.getWindowHandles();

        for (String windowHandle : windows){
            if (!windowHandle.equals(parentWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }



    }
}
