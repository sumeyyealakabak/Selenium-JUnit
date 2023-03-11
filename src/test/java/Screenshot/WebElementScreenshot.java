package Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;

public class WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // Go to amazon homepage
        driver.get("https://www.amazon.com");

        // Search "Nutella"
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Test the result contains "Nutella"
        WebElement resultTextElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualResultText =resultTextElement.getText();
        String expectedContent = "Nutella";

        Assert.assertTrue(actualResultText.contains(expectedContent));

        // And take a photo of the result text element to be added to the report
        // 1- locate the element to be photographed
        // 2- Create a File to save the file
        File elementSs = new File("target/elementScreenshot.jpg");

        // 3- Take screenshot with webElement and save it to temporary file
        File temporaryFile= resultTextElement.getScreenshotAs(OutputType.FILE);

        // 4- Copy the temporary file to elementSs
        FileUtils.copyFile(temporaryFile,elementSs);
    }
}
