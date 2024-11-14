package com.khan.service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.khan.dto.Book;
import com.khan.repo.IBookRepo;

public class FileLoaderService {

	private IBookRepo bookRepo;

	public void setBookRepo(IBookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public void loadDataFromFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Book book = new Book(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]));
				bookRepo.saveBook(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateExcelForBooks(String filepath) {
		
		List<Book> books = bookRepo.getAllBook();

		try (Workbook workbook = new XSSFWorkbook();
				FileOutputStream fos = new FileOutputStream(filepath)) 
		{
			Sheet sheet = workbook.createSheet("books");
			
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("Book ID");
			headerRow.createCell(1).setCellValue("Book Name");
			headerRow.createCell(2).setCellValue("Book Price");
			
			int rowNum=1;
			
			for(Book book: books)
			{
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(book.getBookId());
				row.createCell(1).setCellValue(book.getBookName());
				row.createCell(2).setCellValue(book.getBookPrice());
			}
			
			for(int i =0; i<3; i++)
			{
				sheet.autoSizeColumn(i);
			}
			
			workbook.write(fos);
			System.out.println("EXCEL FILE GENERATED ::  FILE LOCATION : "+filepath);
			
		} catch (IOException e) {
			System.out.println("FAILED TO GENERATE");
		}
	}
}
