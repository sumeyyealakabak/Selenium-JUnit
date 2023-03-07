import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {

    @Test
    public void test01(){

        // Go to: "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        // Scroll to the end of the page
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        // Print the all body of the web table
        WebElement allBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(allBody.getText());

        // Test that the number of rows in the web table is 10
        List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,rowsList.size());

        // Print all rows
        int rowNumber=1;
        for (WebElement eachRow: rowsList
        ) {
            System.out.println(rowNumber + "- " + eachRow.getText());
            rowNumber++;
        }

        // Test that the number of columns in the web table is 13
        List<WebElement> thirdRowDataList =
                driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,thirdRowDataList.size());

        // Print column 5
        List<WebElement> fifthColumnList=
                driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("=====5.column======");
        rowNumber=1;
        for (WebElement eachData:fifthColumnList
        ) {
            System.out.println(rowNumber +"- " + eachData.getText());
            rowNumber++;
        }

        // Create a method that takes the number of rows and columns as parameters and
        // returns the information in the cell
        System.out.println("requested data : \n"+getData(3, 5));

        // Test row 7, data 9 contains "Shoes"
        String actualData=getData(7,9);
        String expectedContent="Shoes";
        Assert.assertTrue(actualData.contains(expectedContent));
        wait(3);
    }

    public String getData(int rowNo, int columnNo){
        // Print the information in row 3, column 5
        //        //tbody/tr[3]/td[5]
        String dataXpath= "//tbody/tr["+ rowNo + "]/td["+ columnNo +"]";
        String requestedData = driver.findElement(By.xpath(dataXpath)).getText();
        return requestedData;
    }
}
