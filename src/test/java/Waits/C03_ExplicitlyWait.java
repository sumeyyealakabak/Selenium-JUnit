package Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_ExplicitlyWait {

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //Go to amazon homepage
        driver.get("https://www.amazon.com");

        // wait until the search box is clickable
        // for explicitly wait:
        //  A- Create a "wait" object
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        // B - if possible locate the webElement
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // C- wait objesini kullanarak istenen gorev icin bekle
        wait.until(ExpectedConditions.elementToBeClickable(aramaKutusu));

        // Search "Nutella"
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
    }

}
