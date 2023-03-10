package Excel;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        /*
            We provide direct access to a file on the computer with our codes.
            We do not get information from that file instantly.
            Instead, at the beginning of the class, the Excel file on our computer:
            1- Creates a copy
            2- Uploads all the information in Excel to the copy workbook
            3- We do all the operations we will do on the workbook
            4- if we update the workbook we created
               to export the final version to excel

               At the end of the class, we save the information in the copy workbook to excel.
         */



        // 1- FilePath is required to access excel on the computer
        String filePath= "src/test/java/Excel/ulkeler.xlsx";

        // 2- To get the information from excel where we created the file path
        //    We need to create FileInputStream object
        FileInputStream fis = new FileInputStream(filePath);

        // 3- In order to be able to work in Excel, whose information we have obtained,
        //    we must create a copied workbook in our code environment
        Workbook workbook = WorkbookFactory.create(fis);

        // All the information in the Excel on our computer
        // now saved in workbook object
        // due to the nature of Excel, in order
        // - requested page
        // - requested line
        // - desired cell
        // must be created / read
        // Test line 12, cell 3 is "Azerbaijan"

        Sheet page1= workbook.getSheet("Sayfa1");
        // uses excel index so it starts from 0

        Row row= page1.getRow(11);

        Cell cell= row.getCell(2);

        String expectedData="Azerbaycan";

        String actualData = cell.toString();

        Assert.assertEquals(expectedData,actualData);
    }
}
