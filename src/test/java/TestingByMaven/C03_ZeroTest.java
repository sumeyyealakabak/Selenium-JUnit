package TestingByMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroTest {
       /*
       1. http://zero.webappsecurity.com sayfasina gidin
       2. Click the "Sign in" button
       3. Type "username" in the login part
       4. Type “password”  in the password part
       5. Click the "Sign in" button
       6. Go to "Pay Bills" page
       7. Type any amount you want to deposit in the "amount"
       8. Type “2020-09-10” on the date part
       9. Click the "Pay" button
       10.Test that the message is output: “The payment was successfully submitted.”
       */
    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.
        driver.get("http://zero.webappsecurity.com");

        //2.
        driver.findElement(By.id("signin_button")).click();

        //3.
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4.
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5.
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // If the page cannot be opened, press the back button.
        driver.navigate().back();

        //6.
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        //7.
        driver.findElement(By.id("sp_amount")).sendKeys("200");

        //8.
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9.
        driver.findElement(By.id("pay_saved_payees")).click();

        //10.
        WebElement mesajElementi = driver.findElement(By.id("alert_content"));
        if (mesajElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }


        driver.close();
    }
}
