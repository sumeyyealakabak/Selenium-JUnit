package Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_FirstAssertion {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public static void teardown(){

        driver.close();
    }

    @Test
    public void titleTest(){
        //  ○ titleTest   => Test that the page title is "YouTube"
        String expectedTitle= "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        //  ○ imageTest   => Test that "YouTube" image is displayed
        WebElement logoElement= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        //  ○ Test that "Search Box" is enabled
        WebElement searchBoxElement= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElement.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //  ○ wrongTitleTest => Verify that the page title is not "youtube"
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }

}
