package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class C04_ExplicitlyWait {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // Go to: "https://the-internet.herokuapp.com/dynamic_controls"
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Verify the "Textbox" is not enabled
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        // Click "Enable" button and wait until "Textbox" enabled
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // If we are going to wait with "explicit wait"
        // A- Create a wait object
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        // B- Locate the WebElement to be used if possible (Textbox == located)
        // C- Wait using wait object
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        // Verify that the message “It's enabled!” is displayed.
        WebElement itsEnabledElement= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledElement.isDisplayed());

        // Verify that "Textbox" is enabled.
        Assert.assertTrue(textBox.isEnabled());
        driver.close();
    }
}
