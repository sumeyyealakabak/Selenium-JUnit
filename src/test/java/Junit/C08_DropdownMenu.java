package Junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class C08_DropdownMenu {


    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        //Launch the browser
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Go to the amazon homepage: "https://www.amazon.com/"
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){

        driver.close();
    }
    @Test
    public void test01(){

        // Test 1: Test that the number of categories in the "Category menu" next to the search box is 45
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        int actualOptionNumber = select.getOptions().size();
        int expectedOptionNumber=45;
        Assert.assertEquals(expectedOptionNumber,actualOptionNumber);
    }


    @Test
    public void test02(){
        // Test 2: 1. Select the "Books" option from the "Category menu"
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //  2. Type "Java" in the search box and search
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //  3. Print the number of results found
        WebElement resultTextElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(resultTextElement.getText());

        //  4. Test that the result contains the word "Java"
        String expectedContent= "Java";
        String actualResultText= resultTextElement.getText();
        Assert.assertTrue(actualResultText.contains(expectedContent));
    }
}
