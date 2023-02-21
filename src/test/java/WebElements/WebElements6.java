package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements6 {
    public static void main(String[] args) {

        //1-  Launch browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  Navigate to url 'https://www.amazon.com/'
        driver.get("https://www.amazon.com/");

        //3-  maximize browser
        //4-  Refresh browser
        driver.navigate().refresh();

        //5-  Test if the page title contains "Spend less".
        String expectedContent="Spend less";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedContent)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }

        //6-  Click the 'Gift Cards' tab
        driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']")).click();

        //7-  Press the 'Birthday' button
        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

        //8-  Click the first item from the 'Best Seller' section
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        //9-  Select $25 from 'Gift card details'
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();

        //10- Test the product price is $25
        WebElement priceElement= driver.findElement(By.cssSelector("#gc-live-preview-amount"));

        String expectedPrice="25$";
        String actualPrice= priceElement.getText();
        if (expectedPrice.equals(actualPrice)){
            System.out.println("Price Test PASSED");
        }else{
            System.out.println("Price test FAILED" +
                    "\nActual price : " + actualPrice);
        }

        //11- Close the browser
        driver.close();

    }
}
