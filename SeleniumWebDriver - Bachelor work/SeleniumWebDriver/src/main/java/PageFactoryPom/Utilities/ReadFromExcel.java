package PageFactoryPom.Utilities;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class ReadFromExcel {
    public static Collection readExcel(String excelPath) throws IOException {
        File file = new File(excelPath);
        FileInputStream inputStream = new FileInputStream(file);
        // OPCPackage pkg = OPCPackage.open(new File(XML_PATH));
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] obg = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
                        obg[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                    }else
                    if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
                        obg[i][j] = String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
                    }
                    else {
                        throw new RuntimeException("Not supported cellType");
                    }

                } catch (RuntimeException e) {
                  throw e;
                }

            }
        }

        return Arrays.asList(obg.clone());
    }
}
