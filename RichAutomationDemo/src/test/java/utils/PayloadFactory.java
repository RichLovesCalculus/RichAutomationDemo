package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class PayloadFactory {

    public static Map<String, String> getPayload(String filePath, int sheetNumber, int rowNumber) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row header = sheet.getRow(0);
        DataFormatter formatter = new DataFormatter();
        Row row = sheet.getRow(rowNumber);
        Map<String, String> rowData = new HashMap<>();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            String key = formatter.formatCellValue(header.getCell(i)).trim();
            String value = formatter.formatCellValue(row.getCell(i)).trim();
            rowData.put(key, value);
        }
        workbook.close();
        Map<String, String> payload = new HashMap<>();
        payload.put("name", rowData.get("name"));
        payload.put("email", rowData.get("email"));
        payload.put("status", rowData.get("status"));
        payload.put("gender", rowData.get("gender"));
        return payload;
    }
}