package seleniumDriversMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumManageMethods {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());

        //we can change the dimensions and location
        driver.manage().window().setSize(new Dimension(800,800));
        driver.manage().window().setPosition(new Point(40,100));

        /*
        When we send the driver a web application
        opening that page
        finding the elements so that we can do something we want on that page...
        Operations like this take time.

        'implicitlywait' for this kind of time-consuming operations
        Specifies how long the driver waits maximum
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));







    }
}
