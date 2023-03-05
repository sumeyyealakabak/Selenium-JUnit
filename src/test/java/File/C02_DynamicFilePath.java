package File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DynamicFilePath {

    @Test
    public void test01(){

        // 1. Test you have "TheDelta.docx" file on your desktop
        String filePath=System.getProperty("user.home")+"\\Desktop\\TheDelta.docx";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void test02(){
        // 1. Test that we have a file named "text.txt" in our project
        String dynamicFilePath="C:\\Users\\A\\Desktop\\selenium_dersleri\\src\\test\\java\\text.txt";

        dynamicFilePath=System.getProperty("user.dir");
        // System.out.println(dynamicFilePath);   //C:\Users\A\Desktop\SeleniumStudies

        dynamicFilePath=System.getProperty("user.dir")+"\\src\\test\\java\\File\\text.txt";
        // src and after "copy path from content root"

        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));


    }

}
