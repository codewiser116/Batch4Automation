package actions;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class PracticeDragAndDrop {
    public static void main(String[] args) {
        /*
        HOW TO DRAG AND DROP:
        1. locate the source element (element to drag)
        2. locate the target element (place where we want to drop the element)
        3. actions.dragAndDrop(sourceElement, targetElement).build.perform();
         */

        /*
        1. go to https://the-internet.herokuapp.com/drag_and_drop
        2. drag A to B
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
//
        Actions actions = new Actions(driver);
//        actions.dragAndDrop(source, target).build().perform();


        /*
        1. go to https://www.way2automation.com/way2auto_jquery/droppable.php#load_box
        2. drag and drop white square into gray square
         */

        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='droppable/default.html']"));
        driver.switchTo().frame(iframe1);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(draggable, droppable).build().perform();






    }
}
