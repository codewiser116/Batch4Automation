package webtables;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class IntroToWebTables {
    /*
        1. go to https://the-internet.herokuapp.com/tables
        2. print http://www.timconway.com
     */

    static WebDriver driver;

    @BeforeClass
    public static void initializeDriver(){
        driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void printTim(){
        WebElement element1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        String element1Text = element1.getText();
        System.out.println(element1Text);
    }

    /* print this
        John Smith
        Frank Bach
        Jason Doe
        Tim Conway
     */

    @Test
    public void printNames(){
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']//tr//td[2]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tr//td[1]"));

        for (int i = 0; i < firstNames.size(); i++){

            String firstName = firstNames.get(i).getText();
            String lastName = lastNames.get(i).getText();

            System.out.println(firstName + " " + lastName);
        }
    }

    /*
    print email and due
    of those people who have due > 50
        fbach@yahoo.com	    $51.00
        jdoe@hotmail.com	$100.00
     */
    @Test
    public void printEmailsOver50(){
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tr//td[3]"));
        List<WebElement> dues = driver.findElements(By.xpath("//table[@id='table1']//tr//td[4]"));

        for (int i = 0; i < emails.size(); i++){
            String email = emails.get(i).getText();
            double due = Double.parseDouble(dues.get(i).getText().replace("$", ""));

            if (due > 50){
                System.out.println(email + " " + due);
            }
        }
    }

    /*
    print email and website of those people whose first name starts with "J"
     */
    @Test
    public void printPeopleWithJ(){
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tr//td[3]"));
        List<WebElement> websites = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));

        for (int i = 0; i < firstNames.size(); i++) {
            String firstName = firstNames.get(i).getText();
            String website = websites.get(i).getText();
            String email = emails.get(i).getText();

            if (firstName.startsWith("J")) {
                System.out.println(firstName + " " + email + " " + website);
            }
        }
    }







}
