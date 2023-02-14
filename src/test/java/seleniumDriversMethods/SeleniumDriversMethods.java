package seleniumDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriversMethods {
    public static void main(String[] args) throws InterruptedException {
          /*
        To automate a project with selenium
        We need to add only one thing to the project
         Selenium library

        1- we download the files from the selenium dev page to our computer
        2- We unzip them and move them to the drivers folder that we created in our project.
        3- We add selenium libraries (jar files) to the project
         */


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // to go to the specified page

        driver.get("https://www.amazon.com/");

        Thread.sleep(3000);

        // print the title and url of the page you are on
        System.out.println("URL : "+driver.getCurrentUrl()); // URL : https://www.amazon.com/
        System.out.println("Title : "+driver.getTitle());

        //test that you go to the amazon homepage
        //Compare test expected result and actual result


        String expectedContent = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedContent)){ // if we went to amazon homepage
            System.out.println("Test PASSED");
        }else {//if we couldn't go
            System.out.println("Test FAILED");
        }

        driver.close();
    }
    }

