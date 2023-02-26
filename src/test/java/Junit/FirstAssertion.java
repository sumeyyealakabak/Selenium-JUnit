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

public class FirstAssertion {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){

        driver.close();
    }

    @Test
    public void test01(){
        //      ○ Test that the page URL is equal to 'https://www.bestbuy.com/'
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02(){
        //      ○ titleTest => Test that the page title does not contain "Rest"
        String expectedContent="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedContent));
    }

    @Test
    public void test03(){
        //      ○ logoTest => Test that the 'BestBuy' logo is displayed
        WebElement logoElement= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void test04(){
        //      ○ FrancaisLinkTest => Test that the French Link is displayed
        WebElement franchLink= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(franchLink.isDisplayed());
    }


}
