package seleniumDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriversMethods {
    public static void main(String[] args) throws InterruptedException {

        /*
        for Apple Safari, Opera, Brave,Vivaldi, DuckDuckgo...
        To automate a project with selenium
        we need to add 2 things to the project
        1- Selenium library
        2- Selenium driver of the browser(s) we want to use

        to add files to the project
        1- we download the files from the selenium dev page to our computer
        2- We unzip them and move them to the drivers folder that we created in our project.
        3- we add selenium libraries (jar files) to the project

            We made Selenium usable by uploading the jar files
            but if we want each class to work with which browser.
            We need to define the driver related to that browser in the class
            In line with our preference regarding the browser
            from the System class in Java to make the relevant settings
            setProperty() is used

            we will add 2 parameters to method
            1. parameter is the same for everyone: webdriver.chrome.driver
            2. parameter is the file path of this driver
              It may be different on everyone's computer.
              On windows computers, .exe should be written at the end
              no .exe on macs

         */

          /*
        for Firefox,Google Chrome,Microsoft Edge
        To automate a project with selenium
        We need to add only one thing to the project
         Selenium library

        1- we download the files from the selenium dev page to our computer
        2- We unzip them and move them to the drivers folder that we created in our project.
        3- We add selenium libraries (jar files) to the project

        We may not write :System.setProperty("Webdriver.chrome.driver","drivers/chromedriver");
        without this we can go on . but it is not fast.

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

