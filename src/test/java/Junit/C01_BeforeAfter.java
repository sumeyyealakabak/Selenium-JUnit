package Junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfter {



        WebDriver driver;

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();

            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            System.out.println("setUp worked");

        }
        @After
        public void teardown(){
            driver.close();
            System.out.println("teardown worked");
        }


        @Test
        public void test01(){
            driver.get("https://wisequarter.com");
            System.out.println("test01 worked");


        }
        @Test
        public void test02(){
            driver.get("https://youtube.com");
            System.out.println("test02 worked");

        }
    }


