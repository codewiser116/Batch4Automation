package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class PracticeDragAndDropOffset {
    public static void main(String[] args) {

        System.out.println(stringReverse2("hello", "hello".length() - 1));



    }
//HUSSSEIN START CODING

//CREATE THIS METHOD FIRST
    // THIS IS INNER METHOD WHICH WILL BE CALLED

    private static String stringReverse2(String input, int index) {
        if (index == 0) {
            return input.charAt(0) + ""; //to make it string
        }

        // here is the main logic
        // we use the index and call the method again to get next index
        // we do -1 to move to next index
        return input.charAt(index) + stringReverse2(input, index - 1);
    }



    /*
    now i create second method which will be main one

     */


    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        return stringReverse2(input, input.length() - 1);
    }


}
