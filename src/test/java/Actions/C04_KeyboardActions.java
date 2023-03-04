package Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //1- Go to: "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        //2- Type "Samsung A71" in the search box using the actions methods and click "Enter" to search.
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions= new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        //3- Test that the search is done
        String actualResultText = driver
                .findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        String expectedContent="Samsung A71";
        Assert.assertTrue(actualResultText.contains(expectedContent));
        wait(4);
    }

}
