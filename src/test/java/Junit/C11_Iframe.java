package Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C11_Iframe extends TestBase {

    @Test
    public void test01(){
        // 1.Go to: "https://the-internet.herokuapp.com/iframe"
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2.Test that the text is displayed : "Your content goes here."

        /*
            Sometimes the locator doesn't work even though we are sure of our locate operation.
            This may be because the WebElement we want to use is a child of an iframe.
            If the WebElement we want to use is another webpage that is embedded in the homepage.
            element, we need to switch to the embedded page first.
            <iframe> is used in HTML commands to embed a page within a page.
            In order to use the element we want, we must first switch to that frame.
            1- Locate the frame you want to pass
            2- Switch to that frame with switchTo()
            3- Then do whatever you want with the element you want.
         */

        WebElement frameElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);


        WebElement textElement = driver.findElement(By.tagName("p"));
        // Although we locate it correctly, the test cannot be performed, it gives an error.
        // That's why we locate the iframe on the 30th line.
        Assert.assertTrue(textElement.isDisplayed());


        // 3.Click the link: "Elemental Selenium"

         /*
         After switching to a frame until you get out of there or switch to another frame
         the driver stays in that frame when we are done or when we want to switch to another frame
         first we have to pass to the place where we will work
         */


        //We exit the iframe in two ways
        //1. Takes it to the next level in nested frames(Even if we do not exit the iframe, it gives an error)
        driver.switchTo().parentFrame();

        // 2. Goes directly to the homepage
        //driver.switchTo().defaultContent();

        driver.findElement(By.linkText("Elemental Selenium")).click();
        wait(3);
    }

}
