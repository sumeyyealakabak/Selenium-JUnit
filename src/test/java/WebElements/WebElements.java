package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements {
    public static void main(String[] args) throws InterruptedException {
    /*
    1. Go to amazon homepage.
    2. Locate the search box
    3. Search by typing "nutella" in the search box
    */


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. Go to amazon homepage.
        driver.get("https://www.amazon.com");



        //The process of describing an element to the driver is called "locate"
        //The variables -that we use-called locater
        // There are 8 locaters
        //6 of the locators depend on the properties of the web element
        //1-id   2-classname   3-name  4-tagname  5-linkText  6-partialLinkText
        //the remaining 2 locators can be used to locate any web element.
        //7- xpath  8-cssSelector

        // 2.locate the search box
        //----id "twotabsearchtextbox" olan web element seklinde locate edecegiz----

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // The thing after "=" is called locate .
        // We need to assign locate to a variable, so we can use it
        // The variable also needs a data type, which is WebElement



        // 3. search by typing "nutella" in the search box
        aramaKutusu.sendKeys("nutella");
        aramaKutusu.submit();


        Thread.sleep(3000);
        driver.close();

}}
