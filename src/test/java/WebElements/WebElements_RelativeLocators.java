package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class WebElements_RelativeLocators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html\n");

        WebElement berlinElement = driver.findElement(By.xpath("//*[@*='pid7_thumb']"));

        WebElement nycElement = driver.findElement(By.xpath("//*[@*='pid3_thumb']"));

        WebElement bostonElement = driver.findElement(By.xpath("//*[@*='pid6_thumb']"));

        WebElement sailorElement = driver.findElement(By.xpath("//*[@*='pid11_thumb']"));

        /*
            A new feature with Selenium4
            In case you can't locate an element
            We can locate that element with 2 things:
                1- Find a web element around (right, left, above, below or near)
                2- A feature (tag, attribute) of the web element that you cannot locate
         */

        WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElement));
        System.out.println("berlin1 id : "+berlin1.getAttribute("id")); // pid7_thumb

        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElement));
        System.out.println("berlin2 id : "+berlin2.getAttribute("id")); // pid7_thumb

        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElement));
        System.out.println("berlin3 id : "+berlin3.getAttribute("id")); // pid7_thumb
    }
}
