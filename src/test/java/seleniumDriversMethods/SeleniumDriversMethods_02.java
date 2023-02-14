package seleniumDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriversMethods_02 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getWindowHandle());
        // CDwindow-EACEEB208F863096E6E81476E52BFD79
        // CDwindow-CA5C444EC94F7E15595E7EF9D44542F5
        // getWindowHandle returns the unique handle value generated by selenium for each driver page
        // getWindowHandels() ise If more than one page is opened during the test,
        // it returns the "window handle" values of all pages as a set

        System.out.println(driver.getPageSource());

        // page codes "2 hours weekly meeting with the team" test if it contains

        String expectedContent = "2 hours weekly meeting with the team";
        String actualPageCodes = driver.getPageSource();

        if (actualPageCodes.contains(expectedContent)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }



        //***********************************


        // go to amazon homepage
        driver.get("https://www.amazon.com");

        // go to wisequarter homepage
        driver.get("https://www.wisequarter.com");

        // again go to amazon homepage
        driver.navigate().back();

        // return wisequarter homepage
        driver.navigate().forward();

        // navigate().to(),  driver.get() does the same
        driver.navigate().to("https://www.youtube.com");

        driver.navigate().refresh();

        //***********************************


        System.out.println("maximize size : " + driver.manage().window().getSize());
        System.out.println("maximize position : " + driver.manage().window().getPosition());


        driver.manage().window().fullscreen();
        System.out.println("fullscreen size : " + driver.manage().window().getSize());
        System.out.println("fullscreen position : " + driver.manage().window().getPosition());


        driver.quit();
        // close() and quit() both are used to close a page
        // close() only when closing a page
        // quit() closes all pages opened during testing

    }
}
