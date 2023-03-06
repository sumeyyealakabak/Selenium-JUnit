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

public class C02_ExplicitlyWait {

    @Test
    public void test01(){

        /*
            Implicitly Wait takes care of most of the waits we need when testing.
            In rare cases, some tasks may need more time than defined for implicitlyWait.
            Explicitly Wait is defined for ONE task to occur on a WebElement
            For this, both the webelement must be defined and the task
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //Go to: "https://the-internet.herokuapp.com/dynamic_controls"
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click "Remove" button
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //Verify the message is displayed: “It’s gone!”

        //   if we use "explicitly wait"
        //   A - Create a "wait" object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        //  B - IF the WebElement we will use is locateable, locate it.
        // WebElement itsGoneElement=
        //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        //  C- IF we need time to locate,
        //     We make the location and task definition in one line
        WebElement itsGoneElement=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        driver.close();
    }
}
