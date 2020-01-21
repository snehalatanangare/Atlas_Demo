package com.qaprosoft.carina.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommomFunctios {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		CommomFunctios obj = new CommomFunctios();
		obj.updateStatus("TEST", 1, 18);
		
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    try {
	        Class c = Class.forName(this.getClass().getName());
	        Method m[] = c.getDeclaredMethods();
	        Object oo;

	        for (int i = 0; i < m.length; i++)
	            if (m[i].getName().startsWith("get")) {
	                oo = m[i].invoke(this, null);
	                sb.append(m[i].getName().substring(3) + ":"
	                        + String.valueOf(oo) + "\n");
	            }
	    } catch (Throwable e) {
	        System.err.println(e);
	    }
	    return sb.toString();
	}
	
	//Method to write in Excel
	public void writeExcel(String excelPath, String sheetName, int row, int col, String value)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(excelPath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        sheet.getRow(row).getCell(col).setCellValue(value);
	        workbook.close();
	        FileOutputStream outFile =new FileOutputStream(new File(excelPath));
			workbook.write(outFile);
			outFile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeJsonFile(String filePath, String data) throws IOException
	{
	    Path path = Paths.get(filePath);
	    Files.write(path, data.getBytes());
	}
	
	public void updateStatus(String status, int row, int cell) throws InterruptedException 
	{
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Q2610\\Desktop\\ApplicationIssuance.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("AutomationResults");
			Row row1 = sheet.getRow(row);
			if(row1 == null)
			row1 = sheet.createRow(row);
			Cell cell1 = row1.getCell(cell);
			if(cell1 == null)
			cell1 = row1.createCell(cell);
			cell1.setCellValue(status);
			file.close();
			FileOutputStream output_file =new FileOutputStream(new File("E:\\ExecutionStatus\\APIStatus.xlsx"));
			workbook.write(output_file);
			output_file.close();
			workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
