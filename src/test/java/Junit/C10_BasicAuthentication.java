package Junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C10_BasicAuthentication extends TestBase {

    @Test
    public void test01(){

        // Go to: "https://the-internet.herokuapp.com/basic_auth"
        // Authenticate using the following method and test data

        //  Html command : https://username:password@URL
        //  Username     : admin
        //  password     : admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Verify that the page has been successfully entered
        String actualEntryText= driver.findElement(By.tagName("p")).getText();
        String expectedContent = "Congratulations";
        Assert.assertTrue(actualEntryText.contains(expectedContent));
}}
