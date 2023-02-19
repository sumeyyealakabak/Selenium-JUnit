package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElements3 {
    public static void main(String[] args) throws InterruptedException {
        /*
          1- Create a test class and make the relevant settings
          2- Go to "https://www.automationexercise.com/"
          3- Test that there are 147 links on the page
          4- Click on the "Products" link
          5- Test that "special offer" displayed
          6- Close the page
         */
        //1
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2
        driver.get("https://www.automationexercise.com/");

        //3
        //Link's tag is "a"
        List<WebElement> linkElementsList=driver.findElements(By.tagName("a"));


        int expectedLinkNumber=147;
        int actualLinkNumber=linkElementsList.size();
        if (expectedLinkNumber==actualLinkNumber)
            System.out.println("Link test number PASSED");
        else System.out.println("Link test number FAILED");

        //4
        driver.findElement(By.partialLinkText("Products")).click();

        //5
        WebElement specialOfferElement= driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()){
            System.out.println("Special offer test PASSED");
        }else{
            System.out.println("Special offer test FAILED");
        }
        //6
        Thread.sleep(3000);
        driver.close();


    }
}
