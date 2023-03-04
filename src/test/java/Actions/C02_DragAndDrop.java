package Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01(){

        // 1- Go to: "https://demoqa.com/droppable"
        driver.get("https://demoqa.com/droppable");

        // 2- Hold the "Drag me" button and drop it above the "Drop here" box
        WebElement dragMeElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        //3- Test instead of “Drop here” text, appears “Dropped!”
        String expectedContent= "Dropped!";
        String actualText= driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedContent,actualText);

        wait(3);
    }
}
