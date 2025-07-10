package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public static List<String> readProductList(String filePath) {
        List<String> products = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                if (cell1 != null) products.add(cell1.getStringCellValue().trim());
                if (cell2 != null) products.add(cell2.getStringCellValue().trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
