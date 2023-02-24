package TestingByMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {


        // Launch browser.
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Go to: "https://www.amazon.com/".
        driver.get("https://www.amazon.com/");

        // Locate the search box
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        // Write: “Samsung headphones” and click.
        searchBox.sendKeys("Samsung headphones" + Keys.ENTER);

        // Print the number of results found
        System.out.println(driver.
                findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText());

        // Click the first product
        driver.
                findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"))
                .click();

        // Print all the titles on the page
        // titles on the left where we can narrow the search
        driver.navigate().back();
        List<WebElement> titleElementsList=
                driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        int titleNo=1;
        for (WebElement eachElement: titleElementsList
        ) {
            System.out.println(titleNo +" --- " + eachElement.getText());
            titleNo++;
        }
        Thread.sleep(3000);
        driver.close();
    }
}
