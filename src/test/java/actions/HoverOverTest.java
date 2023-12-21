package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class HoverOverTest {
    public static void main(String[] args) {
        /*
            1. go to https://magento.softwaretestingboard.com/
            2. hover over "Women"
            3. click on "Tops"
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        /*
        HOW TO HOVER OVER?
            0. create Actions class object
            1. locate parent element
            2. hover over parent element (moveToElement)
            3. locate the child element
            4. move to child element
            5. interact with child element
         */

        Actions actions = new Actions(driver);

        WebElement women = driver.findElement(By.linkText("Women"));
        actions.moveToElement(women).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tops")));

        WebElement tops = driver.findElement(By.linkText("Tops"));
        actions.moveToElement(tops).click().perform();

        /*
            1. hover over "Men"
            2. click on "Bottoms"

            HOW TO HOVER OVER:
                1. locate parent element
                2. actions.moveToElement(parentElement).perform();
                3. locate child element
                4. actions.moveToElement(childElement).click().perform();
         */

        WebElement men = driver.findElement(By.linkText("Men"));
        actions.moveToElement(men).perform();

        WebElement bottoms = driver.findElement(By.linkText("Bottoms"));
        actions.moveToElement(bottoms).click().perform();











    }
}
