package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElements2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //go to amazon homepage
        driver.get("https://www.amazon.com");

        //type java in the search box and search
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java");
        searchBox.submit();

        //print texts on images from search results
        List<WebElement> searchBoxElementList=driver.findElements(By.className("sg-col-inner"));
        System.out.println(searchBoxElementList.size());//86

        //print 86 elements
        int elementNo=1;
        for (WebElement eachElement:searchBoxElementList) {
            System.out.println(elementNo + "---" + eachElement.getText());
            elementNo++;
        }




        Thread.sleep(3000);
        driver.close();


    }
}
