package Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class C09_JsAlert extends TestBaseClass {

    @Test
    public void test01(){

        // Launch the browser

        // Go to: "https://the-internet.herokuapp.com/javascript_alerts"
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click on 1. alert
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        wait(2);

        // Test that the text in Alert is "I am a JS Alert"
        String expectedAlertText="I am a JS Alert";
        String actualAlertText= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);

        // Press the "OK" button and close the alert.
        driver.switchTo().alert().accept();
        wait(2);
    }
    @Test
    public void test02(){

        // Launch the browser

        // Go to: "https://the-internet.herokuapp.com/javascript_alerts"
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click on 2. alert
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //Press "Cancel" and test that the resulting text is "You clicked: Cancel"
        wait(2);
        driver.switchTo().alert().dismiss();

        wait(2);

        String expectedResultText="You clicked: Cancel";
        String actualResultText= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        Assert.assertEquals(expectedResultText,actualResultText);
    }
    @Test
    public void test03(){

        // Launch the browser

        // Go to: "https://the-internet.herokuapp.com/javascript_alerts"
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click on 3. alert
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Print "Anna" on the prompt screen and close the alert by pressing the "OK" button.
        driver
                .switchTo()
                .alert()
                .sendKeys("Anna");
        wait(2);

        driver
                .switchTo()
                .alert()
                .accept();

        // Test that the resulting text contains "Anna"
        wait(2);
        String actualResultText= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        String expectedContent="Anna";
        Assert.assertTrue(actualResultText.contains(expectedContent));
    }

}
