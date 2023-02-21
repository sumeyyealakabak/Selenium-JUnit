package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements5 {
    public static void main(String[] args) throws InterruptedException {

        //1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Click the 'Add Element'
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();


        //3- Test that the 'delete button' is displayed
        WebElement deleteButonElement= driver.findElement(By.xpath("//button[@class ='added-manually']"));
        if (deleteButonElement.isDisplayed()){
            System.out.println("delete button test PASSED");
        }else
            System.out.println("delete button test FAILED");

        //4- Click the 'delete button'
        deleteButonElement.click();

        //5- Test that the text “Add/Remove Elements” is displayed
        WebElement addRemoveElements=driver.findElement(By.xpath("//h3"));
        if (addRemoveElements.isDisplayed()){
            System.out.println("Add/Remove Elements Text test PASSED");
        }else
            System.out.println("Add/Remove Elements Text test FAILED");

        Thread.sleep(3000);
        driver.close();


    }
}
