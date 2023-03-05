package File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUploadTest extends TestBase {

    @Test
    public void test01(){

        // Go to: "https://the-internet.herokuapp.com/upload"
        driver.get("https://the-internet.herokuapp.com/upload");

        //press the "chooseFile" button
        //Select the file you want to upload.
        //Upload the "logo.png" file we downloaded to Downloads

        /*
            If we press the "chooseFile" button
            We need to select a file from our computer.
            However, selenium or java cannot select files from our computer.
            Instead, Selenium has developed a method for us.
            We create the file path of the file we need to select with "chooseFile"
            It is enough to send the created file path to the chooseFile button with sendKeys.
         */

        String dynamicFilePath= System.getProperty("user.home")+"\\Downloads\\picture.png";
        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(dynamicFilePath);

        // Click: "Upload" button
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” Test that the text is displayed.
        WebElement fileUploadedTextElement=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedTextElement.isDisplayed());
        wait(5);
    }
}
