package utils;

import java.util.List;

public class TestDataProvider {
    private static final List<String[]> testData = ExcelReader.getExcelData("G:\\VSCode\\AutomationFramework\\Shopping\\src\\test\\resources\\features\\data\\testData.xlsx", "TestData");
    private static int currentRow = 0;

    public static String[] getNextTestData() {
        if (currentRow >= testData.size()) {
            System.out.println("No more Excel rows.");
            return null;
        }
        return testData.get(currentRow++);
    }
}
