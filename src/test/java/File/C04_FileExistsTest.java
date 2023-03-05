package File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest {

    @Test
    public void test01(){
        //Test that there is a file named "text.txt" in the package we are working with.

        String dynamicFilePath = System.getProperty("user.dir")
                +"\\src\\test\\java\\File\\text.txt";

        System.out.println(dynamicFilePath);
        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));
    }
}
