package alerts;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserPopUp {
    public static void main(String[] args) throws InterruptedException {

        /*
            Pop ups that come from browser cannot be handled by Selenium
            The only way to deal with them is to block them using browser options
            ChromeOptions
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://us06web.zoom.us/j/83993831142?pwd=bm1manRpakkzQkdoZ09ZYnhyYUp3UT09");







    }
}
