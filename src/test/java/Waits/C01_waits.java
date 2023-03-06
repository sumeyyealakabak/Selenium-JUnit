package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C01_waits {

    @Test
    public void test01(){

        //Launch the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Go to: "https://the-internet.herokuapp.com/dynamic_controls"
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click "Remove" button
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //Verify the message is displayed: “It’s gone!”
        WebElement itsGoneElement=
                driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        driver.close();
    }
}
