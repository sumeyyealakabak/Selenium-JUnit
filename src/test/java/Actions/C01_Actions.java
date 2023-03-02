package Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_Actions extends TestBase {
    @Test
    public void test01(){
        // Go to: "https://the-internet.herokuapp.com/context_menu"
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Click on the right drawn area
        Actions actions= new Actions(driver);
        WebElement drawnAreaElement= driver.findElement(By.id("hot-spot"));
        actions.contextClick(drawnAreaElement).perform();

        // Test that the text in alert is "You selected a context menu".
        String expectedAlertText = "You selected a context menu";
        String actualAlertText= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);

        // Close the alert by clicking "OK"
        driver.switchTo().alert().accept();

        // Click on the "Elemental Selenium" link
        String firstPageWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // (for opening another page with the link)
        Set<String> allWHDSet= driver.getWindowHandles(); // [ilkSayfaWHD,ikinciSayfaWHD]
        String secondPageWHD ="?";
        for (String each: allWHDSet
        ) {
            if (!each.equals(firstPageWHD)){
                secondPageWHD = each;
            }
        }

        driver.switchTo().window(secondPageWHD);


        // Test that "Elemental Selenium" is written in the "h1" tag on the page that opens
        String expectedText= "Elemental Selenium";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText,actualText);
        wait(3);
    }
}
