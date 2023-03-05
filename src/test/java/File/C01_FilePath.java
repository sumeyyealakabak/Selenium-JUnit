package File;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilePath {

    @Test
    public void test01(){

        //when we check if the file is on the desktop
        //C:\Users\A\Desktop\
        String filePath="C:\\Users\\A\\Desktop\\TheDelta.docx";
        boolean result= Files.exists(Paths.get(filePath));
        System.out.println(result);

        //we can get the part that is different according to everyone's computer with a command from java

        /*
       base file path of our computer: "user.home"(the part that is different for everyone)
       the rest is Desktop and filename.
         */
        System.out.println(System.getProperty("user.home"));

        //We can write the path of the file:
        System.out.println(System.getProperty("user.home")+"\\Desktop\\TheDelta.docx");


    }


    @Test
    public void test02(){
        //when we check that the "text.txt" file exists in our project

        //the basic path of the project we are in: user.dir (the part that is different for everyone)
        System.out.println(System.getProperty("user.dir"));

        //src and after "copy path from content root"
        System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\File\\text.txt");



    }
}
