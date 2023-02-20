package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements4 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- Go to https://www.amazon.com/
        2- Type 'city bike' in the search box  and search.
        3- Print the number of displayed results
        4- Click on the picture of the first product in the list.
         */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1
        driver.get("https://www.amazon.com/");

        //2
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike" + Keys.ENTER);

        // 3
        WebElement displayedResultsNumber= driver.findElement(By.className("rush-component"));
        System.out.println(displayedResultsNumber.getText());

        //  4
        driver.findElement(By.className("s-image")).click();


        Thread.sleep(3000);
        driver.close();


    }
    }


