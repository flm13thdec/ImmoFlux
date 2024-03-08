package com.apollons.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	
	static FileInputStream fis;
	
	public static List<HashMap<String,String>> getTestData() 
	{
		
		
		try {
			fis=new FileInputStream("testdata\\IMMOFLUX CRM.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb=null;;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws=wb.getSheet("Foaie1");
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws);
		
		ArrayList<HashMap<String, String>> testDataMapList=new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> testDataMap=null;
		
		for(int i=1;i<=testCaseRows.size()-1;i++)
		{
			testDataMap=new HashMap<String, String>();
			
			int noOfCells=testCaseRows.get(i).getLastCellNum();
			
			System.out.println("noOfCells"+noOfCells);
			
			for(int j=0;j<noOfCells;j++)
			{
				if(testCaseRows.get(i).getCell(j).getCellType()==CellType.NUMERIC)
				{
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(),Integer.toString( (int)testCaseRows.get(i).getCell(j).getNumericCellValue()));
				System.out.println(i+"-"+j+"-"+Integer.toString( (int)testCaseRows.get(i).getCell(j).getNumericCellValue()));
				}
				else if(testCaseRows.get(i).getCell(j).getCellType()==CellType.STRING)
				{
				
				if(testCaseRows.get(i).getCell(j).getStringCellValue().equalsIgnoreCase("LINK"))
				{
					Hyperlink hyperlink=testCaseRows.get(i).getCell(j).getHyperlink();
					System.out.println(i+"-"+j+"-"+hyperlink.getAddress());
					testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), hyperlink.getAddress());
					
				}
				else
				{
					System.out.println(i+"-"+j+"-"+testCaseRows.get(i).getCell(j).getStringCellValue());
					testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(i).getCell(j).getStringCellValue());
					
				}
				}
				
			}
			
			System.out.println(testDataMap);
			
			testDataMapList.add(testDataMap);
		}
		
		return testDataMapList;
		
	}
	
	public static HashMap<String,String> getTestData2(String testcase) 
	{
		
		
		try {
			fis=new FileInputStream("testdata\\IMMOFLUX CRM.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb=null;;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws=wb.getSheet("Foaie1");
		
		ArrayList<Row> testCaseRows=getTestCaseRows2(ws,testcase);
		
		HashMap<String, String> testDataMap=new HashMap<String, String>();
		
		for(int i=1;i<=testCaseRows.size();i++)
		{
			
			int noOfCells=testCaseRows.get(0).getLastCellNum();
			System.out.println("noOfCells"+noOfCells);
			
			for(int j=1;j<noOfCells;j++)
			{
				if(testCaseRows.get(i).getCell(j).getCellType()==CellType.NUMERIC)
				{
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(),Integer.toString( (int)testCaseRows.get(i).getCell(j).getNumericCellValue()));
				}
				else if(testCaseRows.get(i).getCell(j).getCellType()==CellType.STRING)
				{
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(i).getCell(j).getStringCellValue());
				}
			}
		}
		
		return testDataMap;
		
	}
	
	static ArrayList<Row> getTestCaseRows(XSSFSheet ws) {
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
				
			}
		}
		
		System.out.println("No of allRows "+allRows.size());
		
		
		
		return allRows;
		
	}
	static ArrayList<Row> getTestCaseRows2(XSSFSheet ws,String testcase) {
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
				
			}
		}
		
		System.out.println("No of allRows "+allRows.size());
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase))
			{
				testCaseRows.add(allRows.get(i));
			}
		}
		
		return testCaseRows;
		
	}

}
