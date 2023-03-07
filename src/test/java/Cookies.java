import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void test01(){

        // Go to amazon homepage
        driver.get("https://www.amazon.com");

        // List the all cookies
        Set<Cookie> cookiesSet= driver.manage().getCookies();
        int orderNumber=1;
        for (Cookie eachCookie:cookiesSet
        ) {
            System.out.println(orderNumber + "- " + eachCookie.toString());
            orderNumber++;
        }
        // Test if the number of cookies on the page is more than 5
        Assert.assertTrue(cookiesSet.size()>5);

        // Test that the value of the cookie with the name "i18n-prefs" is "USD"
        String actualValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedValue= "USD";
        Assert.assertEquals(expectedValue,actualValue);

        // Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        Cookie myCookie= new Cookie("my favorite cookie","chocolate");
        driver.manage().addCookie(myCookie);

        cookiesSet= driver.manage().getCookies();
        orderNumber=1;
        for (Cookie eachCookie:cookiesSet
        ) {
            System.out.println(orderNumber + "- " + eachCookie.toString());
            orderNumber++;
        }

        // Test that the cookie you added is added to the page
        actualValue=driver.manage().getCookieNamed("my favorite cookie").getValue();
        expectedValue="chocolate";
        Assert.assertEquals(expectedValue,actualValue);

        // Delete the cookie with the name "skin" and test it is deleted
        driver.manage().deleteCookieNamed("skin");

        System.out.println("=========");

        // I can't test an element that doesn't exist
        // Instead we control every cookie we handle with the for-each Loop
        // If the name is "skin", the test failed
        cookiesSet= driver.manage().getCookies();
        for (Cookie eachCookie:cookiesSet
        ) {
            Assert.assertFalse(eachCookie.getName().equals("skin"));
        }

        // Delete all cookies and test that they are deleted
        driver.manage().deleteAllCookies();
        cookiesSet= driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.size()==0);
    }
}
