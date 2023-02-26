package Junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown(){
        driver.close();

    }

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        String expectedContent= "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedContent)){
            System.out.println("Amazon test PASSED");
        }else{
            System.out.println("Url does not contains 'amazon', test FAILED");
        }
    }

    @Test
    public void test02(){
        // Search for "Nutella"
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Test if the search results contain "nutella"
        WebElement searchResultElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedContent= "Nutella";
        String actualResultText= searchResultElement.getText();
        if (actualResultText.contains(expectedContent)){
            System.out.println("Nutella test PASSED");
        }else {
            System.out.println("Nutella test FAILED");
        }
    }
    @Test @Ignore
    public void test03(){
        // Click the first product
        WebElement firstProduct= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        firstProduct.click();

        //Test for "Nutella" in the product name
        WebElement productNameElement= driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedContent= "Nutella";
        String actualProductName= productNameElement.getText();
        if (actualProductName.contains(expectedContent)){
            System.out.println("First product test PASSED");
        }else{
            System.out.println("First product test FAILED");
        }
    }


}
