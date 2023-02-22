package SeleniumDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class exercise {
    public static void main(String[] args) {
 /*
      1. Open a new class
      2. Go facebook homepage using ChromeDriver and
         verify title is "facebook",if not print the correct title
      3. Verify URL contains the word "facebook", if not
         print the "actual" URL.
      4. Go to https://www.walmart.com/ page
      5. Verify title includes “Walmart.com”.
      6. Return the “facebook” page
      7. Refresh the page
      8. Maximaze the page
      9. Close the browser
         */


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Facebook title test passed");
        }else System.out.println("Facebook title test failed"+"\nActual title: "+actualTitle);

        //3
        String expectedContent="facebook";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedContent)){
            System.out.println("Facebook url test passed");
        }else System.out.println("Facebook url test failed"+"\nActual Url: "+actualUrl);

        //4
        driver.get("https://www.walmart.com/");

        //5
        String WallmartExpectedContent="facebook";
        String WallmartActualTitle=driver.getTitle();

        if (WallmartActualTitle.contains(WallmartExpectedContent)){
            System.out.println("Wallmart title test passed");
        }else System.out.println("Wallmart title test failed");

        //6
        driver.navigate().back();

        //7
        driver.navigate().refresh();

        //8
        driver.manage().window().maximize();

        //9
        driver.close();

    }
}
