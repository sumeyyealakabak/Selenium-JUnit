package Excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {

        String filePath= "src/test/java/Excel/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet page1= workbook.getSheet("Sayfa1");

        // Follow the steps up to the 1st line
        // Create a new cell for the cell at 4.index
        // Print “Population” in the cell we created
        page1.getRow(0).createCell(4).setCellValue("Nufus");

        // Print 1500000 in the 2nd line population column
        page1.getRow(1).createCell(4).setCellValue("1500000");

        // Print 250000 in the 10th row population column
        page1.getRow(9).createCell(4).setCellValue("250000");

        // Print 54000 on line 15 population column
        page1.getRow(14).createCell(4).setCellValue("54000");

        // Save the file
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        // Close the file
        fis.close();
        fos.close();
        workbook.close();
    }


}
