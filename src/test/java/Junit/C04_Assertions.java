package Junit;

import org.junit.Assert;
import org.junit.Test;

public class C04_Assertions {
    /*
           JUnit tests passed or failed
           decides according to problems occur while executing the codes
           With Assert, we can clearly see whether the test failed or passed.
        */
    String str1= "Ali";
    String str2= "ali";
    @Test
    public void test01(){
        // Test that str1 is equal to str2
        Assert.assertEquals("compared values are different",str1,str2);//Written messages will appear when test failed
        //        if(str1.equals(str2)){
        //            System.out.println("equality test passed");
        //        }else {
        //            System.out.println("equality test failed");
        //        }
    }
    @Test
    public void test02(){
        // Test that str1 contains the letter 'A'
        Assert.assertTrue("str1 does not contain the requested letter",str1.contains("A"));//Written messages will appear when test failed
        //        if(str1.contains("A")){
        //            System.out.println("positive, test passed");
        //        }else {
        //            System.out.println("negative, test failed");
        //        }
    }
    @Test
    public void test03(){
        // test that str2 does not contain the letter 'c'
        Assert.assertFalse("str2 contains unwanted letter",str2.contains("c"));//Written messages will appear when test failed
        //        if (!str2.contains("c")){
        //            System.out.println("negative, test passed");
        //        }else{
        //            System.out.println("positive, test failed");
        //        }
    }
}
