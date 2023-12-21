package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class PracticeRightClick {
    public static void main(String[] args) {
        /*
            1. go to https://the-internet.herokuapp.com/context_menu
            2. right click on black box
         */

        WebDriver driver = Driver.getDriver();
//        driver.get("https://the-internet.herokuapp.com/context_menu");
//
//        WebElement blackBox = driver.findElement(By.id("hot-spot"));
//        Actions actions = new Actions(driver);
//
//        actions.contextClick(blackBox).perform();

        /*
            1. go to https://demo.guru99.com/test/simple_context_menu.html
            2. right click on "right click me" button
            3. double click on "double click me" button
         */

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick2 = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClick2).perform();

        WebElement edit = driver.findElement(By.xpath
                ("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit context-menu-visible']"));
        actions1.moveToElement(edit).click().perform();

        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().sendKeys("");




//        WebElement element = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
//        actions1.doubleClick(element).perform();


    }
}
