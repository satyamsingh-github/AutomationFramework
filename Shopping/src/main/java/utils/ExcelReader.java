package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<String[]> getExcelData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("G:\\VSCode\\AutomationFramework\\Shopping\\src\\test\\resources\\features\\data\\testData.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("TestData");
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String website = row.getCell(0).getStringCellValue();
                String product = row.getCell(1).getStringCellValue();
                String condition = row.getCell(2).getStringCellValue();
                data.add(new String[]{website, product, condition});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    
}
