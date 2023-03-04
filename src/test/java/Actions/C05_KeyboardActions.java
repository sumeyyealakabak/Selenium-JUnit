package Actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //1- Go to: "https://www.facebook.com"
        driver.get("https://www.facebook.com");

        //2- Click the "Create new account" button
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"))
                .click();

        //3- Type values in the name, surname, mail and password boxes and press the "register" button
        wait(2);
        WebElement nameBox= driver.findElement(By.xpath("//input[@placeholder='First name']"));
        Actions actions= new Actions(driver);
        Faker faker= new Faker();
        String fakeEmailAddress=faker.internet().emailAddress();
        actions.click(nameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


    }

}
