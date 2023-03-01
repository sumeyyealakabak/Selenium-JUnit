package Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C12_C03_SwitchWindows extends TestBase {
    @Test
    public void test01(){

        // 1. Go to amazon homepage and test the search box is enabled
        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

        String amazonWindowHandleValue= driver.getWindowHandle();
        wait(2);

        // 2. Go to "https://www.wisequarter.com" as a new tab

        /* first create a new tab
           we have to switch the driver to that page
         */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // 3. Test the url contains "wisequarter"
        String expectedContent="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedContent));
        String wiseWindowHandleValue= driver.getWindowHandle();

        // 4. Go back to the tab where amazon is open

        /*
            To switch to a previously opened window
            We need the WindowHandle of that page.
            If our test includes such a task
            While on that page, we should take the windowHandle value and save.
         */
        driver.switchTo().window(amazonWindowHandleValue);


        // 5. Search "Nutella"
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // 6. Test the results contains "Nutella"
        String actualResultText= driver
                .findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        expectedContent="Nutella";
        Assert.assertTrue(actualResultText.contains(expectedContent));

        // 7. Go to "https://www.youtube.com" as a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        // 8. Test the url contains "youtube"
        expectedContent="youtube";
        actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedContent));
        wait(2);

        // 9. Return to the page where "https://www.wisequarter.com" is open
        driver.switchTo().window(wiseWindowHandleValue);

        // 10. Test the title contains "Wise Quarter"
        expectedContent="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedContent));

        wait(3);
    }
}
