package javascriptExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.UtilWait;

import java.util.List;

public class IntroToJS {

    /*
    1. go to https://www.eatthismuch.com/
    2. click on Browse Foods
    3. print all foods from Page 1
    4. move to Page 2, print all foods
    5. move to Page 3, print all foods
     */

    WebDriver driver = Driver.getDriver();

    @Test
    public void EatThisMuch() throws InterruptedException {
        driver.get("https://www.eatthismuch.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/food/browse/?type=recipe']")));

        for (int page = 1; page < 6; page++) {

            printFoods(driver, page);

            if(page < 5){
                UtilWait.waitUntilElementIsClickable(driver, 5, By.xpath("//a[@href='/food/browse/?type=recipe&page=" + (page + 1) + "']"));
                js.executeScript("arguments[0].click();",
                        driver.findElement(By.xpath("//a[@href='/food/browse/?type=recipe&page=" + (page + 1) + "']")));
            }
        }
    }

    public void printFoods(WebDriver driver, int page){
        UtilWait.waitUntilElementIsVisible(driver, 5, By.xpath("//div[@class='row food_result']"));

        WebElement foodContainer = driver.findElement(By.xpath("//div[@class='row food_result']"));
        System.out.println("Page: " + page);
        for (WebElement foodElement : foodContainer.findElements(By.xpath("//div[@class='result_name col-3']"))) {
            System.out.println(foodElement.getText());
        }
    }


    @Test
    public void testSendKeys(){
        /*
        1. go to https://www.eatthismuch.com/app/registration
        2. send keys to username
        3. send keys to email
        4. send keys to password
         */

        driver.get("https://www.eatthismuch.com/app/registration");

        WebElement username = driver.findElement(By.xpath("(//div[@class='svelte-1brqcpa'])[1]/input"));
        WebElement email = driver.findElement(By.xpath("(//div[@class='svelte-1brqcpa'])[2]/input"));
        WebElement password = driver.findElement(By.xpath("(//div[@class='svelte-695ua8'])[1]/input"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value='benazircodewise';" +
                            "arguments[1].value='benazircodewise@gmail.com';" +
                            "arguments[2].value='abc123xyz!';",
                username, email, password);

        /*
        js.executeScript(“document.getElementByID(‘element id ’).value = ‘xyz’;”);
        js.executeScript("arguments[0].value='gold mining';", element);

         */

    }

    @Test
    public void testCheckbox(){

        /*
        1. go to https://the-internet.herokuapp.com/checkboxes
        2. select checkbox 1
        3. desselect checbox 2

        js.executeScript(“document.getElementByID(‘element id ’).checked=false;”);
        js.executeScript("arguments[0].checked = true;", element);
         */
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

//        js.executeScript("arguments[0].checked=true;", checkbox1);
//        js.executeScript("arguments[0].checked=false;", checkbox2);

        js.executeScript("arguments[0].checked=true; arguments[1].checked=false;", checkbox1, checkbox2);
    }

    @Test
    public void testScrollDown() throws InterruptedException {
        /*
        1. go to https://the-internet.herokuapp.com/infinite_scroll
        2. scroll down a bit
        3. scroll up
         */

        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        System.out.println(driver.manage().window().getSize().getHeight());
        System.out.println(driver.manage().window().getSize().getWidth());

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //to scroll down, provide positive int
        js.executeScript("window.scrollBy(0,5000)");

        Thread.sleep(3000);

        //to scroll up, provide negative int
        js.executeScript("window.scrollBy(0,-5000)");
    }


















}
