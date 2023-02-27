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
public class C06_CheckBox {



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
    public void test01() throws InterruptedException {

        // b.Go to the given web page: "https://the-internet.herokuapp.com/checkboxes"
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // c. Locate the checkbox1 and checkbox2 elements.
        WebElement cb1= driver.findElement(By.xpath(" (//input [@type='checkbox'])[1]"));
        WebElement cb2= driver.findElement(By.xpath(" (//input [@type='checkbox'])[2]"));

        // d. Click the checkbox if Checkbox1 is not selected
        Thread.sleep(3000);
        if (!cb1.isSelected()){
            cb1.click();
        }

        //  e. Click the checkbox if Checkbox2 is not selected
        if (!cb2.isSelected()){
            cb2.click();
        }

        Thread.sleep(3000);

        // f. Test that checkbox1 and checkbox2 are selected
        Assert.assertTrue(cb1.isSelected());
        Assert.assertTrue(cb2.isSelected());
    }

}
