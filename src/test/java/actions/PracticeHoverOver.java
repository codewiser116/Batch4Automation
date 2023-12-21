package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class PracticeHoverOver {
    /*
        1. go to https://the-internet.herokuapp.com/hovers
        2. hover over user1
        3. click on "View profile", it will take you to new page
        4. navigate back
        5. hover over user2
        6. click on "View profile", it will take you to new page
        7. navigate back
        8. hover over user2
        9. click on "View profile", it will take you to new page
        10. navigate back
     */

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement user1 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        WebElement user2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        WebElement user3 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));

        Actions hoverOver = new Actions(driver);

        clickOnUserProfile(driver, hoverOver, user1);
        clickOnUserProfile(driver, hoverOver, user2);
        clickOnUserProfile(driver, hoverOver, user3);
    }

    public static void clickOnUserProfile(WebDriver driver, Actions hoverOver, WebElement user){
        hoverOver.moveToElement(user).click().perform();

        WebElement viewProfile = driver.findElement(By.linkText("View profile"));

        viewProfile.click();
        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.navigate().back();
    }


}
