package Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import utilities.TestBase;

public class AllPageScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // Go to amazon homepage
        driver.get("https://www.amazon.com");

        // Search "Nutella"
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Test the result contains "Nutella"
        String actualResultText = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();

        String expectedContent = "Nutella";

        Assert.assertTrue(actualResultText.contains(expectedContent));


        // And take a photo of the whole page to be included in the report
        // For the whole page screenshot
        // 1- Create TakeScreenshot object
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2- Create a file to save the screenshot
        File wholePageSs = new File("target/screenshot.png");

        // 3- Create a temporary file and save the photo taken with the ts object to the file
        File temporaryPicture= ts.getScreenshotAs(OutputType.FILE);

        // 4- Copy the temporary file to the wholePageSs file
        FileUtils.copyFile(temporaryPicture,wholePageSs);
        wait(3);
    }
}
