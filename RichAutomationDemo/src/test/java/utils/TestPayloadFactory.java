package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPayloadFactory {

    public static List<Map<String, String>> getPayloadsFromExcel(String filePath) throws Exception {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row header = sheet.getRow(0);
        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                String key = formatter.formatCellValue(header.getCell(j)).trim();
                String value = formatter.formatCellValue(row.getCell(j)).trim();
                rowData.put(key, value);
            }
            data.add(rowData);
        }
        workbook.close();
        return data;
    }

    public static Map<String, Object> buildPayload(Map<String, String> rowData) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", rowData.get("name"));
        payload.put("email", rowData.get("email"));
        payload.put("status", rowData.get("status"));
        payload.put("gender", rowData.get("gender"));
        return payload;
    }

}