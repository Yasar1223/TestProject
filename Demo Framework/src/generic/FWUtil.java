package generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtil {
	public static String getXlData(String path, String sheet, int r, int c)
	{
		String v= "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static int getXlRowCount(String path, String sheet) {
		int count = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			count = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void setXlData(String path, String sheet, int r, int c, int v) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(c);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getPhoto(WebDriver driver, String path) {
		try {
			TakesScreenshot t = (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File dstFile = new File(path);
			FileUtils.copyFile(srcFile, dstFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
