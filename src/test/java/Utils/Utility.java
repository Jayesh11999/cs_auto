package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Utility {
    public static String getDataFromExcel() {
        File excelFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Utils\\CSData.xlsx");
        XSSFWorkbook workbook = null;

        try {
            FileInputStream fisFile = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(0);

        String taskName = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println(taskName);

        return taskName;
    }

}
