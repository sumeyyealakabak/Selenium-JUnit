package Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C13__SwitchToWindow extends TestBase {
    @Test
    public void test01(){

        //● Go to: "https://the-internet.herokuapp.com/windows"
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Verify that the text on the page is "Opening a new window".
        WebElement firstPageTextElement= driver.findElement(By.tagName("h3"));
        String expectedText="Opening a new window";
        String actualText= firstPageTextElement.getText();
        Assert.assertEquals(expectedText,actualText);

        //● Verify that the title on the page is: “The Internet”
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        wait(2);
        String firstPageWHD=driver.getWindowHandle();

        //● Press the button: "Click Here"
        driver.findElement(By.linkText("Click Here")).click();

        //● Verify that the page title of the new window that opens is: “New Window”.
        /*
            If the switchToNewWindow() method is used
            the driver switches to the newly opened page.
            However, using this method
            when a link is clicked, a new page opens
            The driver does not switch to the new page.
            Our new open page
            find the windowHandle value
            We MUST switch the driver to that page.
            When we click on the link, we have 2 open pages.
            One of them is the FIRST PAGE where we save the windowHandle value.
            The other is the SECOND PAGE where we do not know the value of windowHandle.
            with the getWindowHandles() method
            We can get the windowHandle values of two pages as a SET.
            In that SET
            String not equal to firstPageWHD
            We can assign it as SecondPageWHD
         */

        Set<String> allPagesWHDSet= driver.getWindowHandles();
        String secondPageWHD="";
        for (String each: allPagesWHDSet
        ) {
            if (!each.equals(firstPageWHD)){
                //On line 29, the first page window Handle value must exist so that it can distinguish the second
                secondPageWHD=each;
            }
        }

        //What we did on lines 54-62 was to find the windowHandle value on our second page.
        driver.switchTo().window(secondPageWHD);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        wait(2);
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Verify that the text on the page is "New Window".
        String secondPageText= driver.findElement(By.tagName("h3")).getText();
        expectedText="New Window";
        Assert.assertEquals(expectedText,secondPageText);

        //●Go back to previous window
        driver.switchTo().window(firstPageWHD);

        //● Verify that the page title is “The Internet”.
        expectedTitle = "The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        wait(3);
    }

}
