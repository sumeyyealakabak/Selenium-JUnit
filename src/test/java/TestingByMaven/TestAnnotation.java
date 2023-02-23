package TestingByMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestAnnotation {
    /*
        Framework : Joint working framework
                    It determines which files we create where, thus facilitating batch work
                    Every framework, besides creating file layout,
                    It has introduced new features that make our work easier.
                    JUnit framework is the most basic testing framework
                    The most important feature it has given us is @Test Annotation.
                    Thanks to the @Test notation, each method
                    Have an independently executable TEST Method
                    Thanks to the @Test notation, we can run each test method independently, alone, if we want.
                    if desired, run from class level,
                    we can make sure all the tests work
                    However, in JUnit framework, we don't know in which order test methods will run.
                    (WE CAN'T FORESEE (we can't schedule the order) and WE CAN'T CONTROL (we're not in control))
                    */



    @Test
    //@: They are metadata, it works wherever we put it. With JUnit, a stand-alone test can be run without a main method.

    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://wisequarter.com");
        driver.close();

    }
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://youtube.com");
        driver.close();


    }
}
