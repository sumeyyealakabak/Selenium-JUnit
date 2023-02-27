package Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_RadioButtons {

    WebDriver driver;

    @Before
    public void setup(){
        // a.Launch the browser
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){

        driver.close();
    }
    @Test
    public void test01(){
        // b.Go to the given web page: "https://facebook.com"
        driver.get("https://facebook.com");

        // c.Click the button :  "Create an account"
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();

        // d.Locate the radio button elements and choose the one that suits you
        WebElement femaleElement= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleElement= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customElement= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        maleElement.click();

        // e.Test that the selected radio button is selected and the others are not
        Assert.assertTrue(maleElement.isSelected());
        Assert.assertFalse(femaleElement.isSelected());
        Assert.assertFalse(customElement.isSelected());
    }
}
