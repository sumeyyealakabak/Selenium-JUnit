package Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){

        //1- Go to: "https://www.amazon.com/"
        driver.get("https://www.amazon.com/");

        //2-Move the mouse over this menu to open the "Account & Lists" menu in the upper right section.
        WebElement accountListElement= driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'] )[1]"));
        Actions actions= new Actions(driver);
        actions.moveToElement(accountListElement).perform();
        wait(2);

        //3- Click the button: “Create a list”
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //4- Test that there is "Your Lists" on the page that opens
        WebElement yourListsElement= driver.findElement(By.id("my-lists-tab"));
        Assert.assertTrue(yourListsElement.isDisplayed());
        wait(4);
    }
}
