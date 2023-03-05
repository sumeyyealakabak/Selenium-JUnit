package File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilePathText extends TestBase {

    @Test
    public void test01() {

        // 1. Go to: "https://the-internet.herokuapp.com/download"
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. Download "picture.png"
        driver.findElement(By.linkText("picture.png")).click();

        // 3. Create dynamic file path as file will download to downloads
        String dynamicFilePath=System.getProperty("user.home")+"\\Downloads\\picture.png";

        // 4. Test if the file was downloaded successfully
        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));




    }
}
