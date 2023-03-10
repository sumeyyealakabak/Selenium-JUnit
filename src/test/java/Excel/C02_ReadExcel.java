package Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        String filePath="src/test/java/Excel/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(filePath);

        Workbook workbook= WorkbookFactory.create(fis);

        //      - Go to cell 2 on line 1 and print
        System.out.println(workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1));

        //     - Assign cell 2 on line 1 to a string variable and print
        String requestedData= workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1)
                .toString();

        System.out.println("Requested data : " + requestedData);


        //      - Test line 2. and 4.cell is the capital of Afghanistan
        String expectedData = "Kabil";
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .getCell(3)
                .toString();

        Assert.assertEquals(expectedData,actualData);


        //     - Find the number of lines
        //    getLastRowNum() returns the index of the last row
        System.out.println("Line number : " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));


        //    - Find the number of lines in sheet2 and the number of lines used physically
        System.out.println("Sayfa2 number of lines : " + (workbook.getSheet("Sayfa2").getLastRowNum()+1));
        System.out.println("Sayfa2 number of physically used lines: " +
                workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());


        //      - Save country names and capitals as a map in English
        Map<String,String> countriesMap = new TreeMap<>();

        int lastRowIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i <=lastRowIndex ; i++) { // we start at 1 to not get the title

            String country= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String capital=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            countriesMap.put(country,capital);
        }

        System.out.println(countriesMap);
        Set<Map.Entry<String,String>> countriesEntrySet= countriesMap.entrySet();
        for (Map.Entry<String,String> eachEntry: countriesEntrySet
        ) {
            System.out.println(eachEntry);
        }
    }
}
