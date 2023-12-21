package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class IntroToActions {

    public static void main(String[] args) {
        /*
            go to https://www.browserstack.com/
            click on “Get started free”
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.browserstack.com/");

        /*
            option 1 to click
         */
        WebElement getStartedButton = driver.findElement(By.id("signupModalProductButton"));
//        getStartedButton.click();

        /*
            option 2 to click
         */
        Actions actions = new Actions(driver);
        actions.moveToElement(getStartedButton).click().perform();

    }

}
