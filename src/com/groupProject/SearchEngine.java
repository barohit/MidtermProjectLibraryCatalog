package com.groupProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngine {
	
	final static String filePath = "books.txt"; 
	
	public static void createFile() {
		Path path = Paths.get(filePath); 
		if (!(Files.exists(path))) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				System.out.println("Sorry, file doesn't exist"); 
			}  
		}

	}
	
	public static void deleteFile() {
		Path path = Paths.get(filePath); 
		File f = path.toFile();
		f.delete(); 
	}
	
	public static void readFromFile() { 
		createFile(); 
		Path path = Paths.get(filePath); 
		File f = path.toFile();  
		BufferedReader br = null; 
		ArrayList <Book> books = new ArrayList<Book>(); 
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine(); 
			while (line != null) {
				 
				String[] components = line.split(",");
				
				//converts to boolean and Date so that the constructor will take them. 
				boolean constructorVal = Boolean.parseBoolean(components[2]); 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				Locale lc = new Locale("EN", "US");
				dtf = dtf.withLocale(lc);
				
				LocalDate constructorVal2 = LocalDate.parse(components[3], dtf);
				
				Book b = new Book(components[0], components[1], constructorVal, constructorVal2);
				books.add(b); 
				line = br.readLine(); 
			}
			br.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("File not created"); 
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sorry, the file is empty");  
		} 
		for (Book currBook: books) {

			System.out.printf("Author: %-15s\n Title: %-15s\n Due Date: %-15s\n Checked out: %-15s\n\n",currBook.getAuthor(),currBook.getTitle(),currBook.getDueDate(),currBook.getStatus()); 
		}
	}	
	
	public static void copyToFileMinusBook(Book b) {  
		 
		Path path = Paths.get(filePath); 
		File f = path.toFile();  
		BufferedReader br = null; 
		ArrayList <Book> books = new ArrayList<Book>(); 
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine(); 
			while (line != null) {
				 
				String[] components = line.split(",");
				
				//converts to boolean and Date so that the constructor will take them. 
				boolean constructorVal = Boolean.parseBoolean(components[2]); 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				Locale lc = new Locale("EN", "US");
				dtf = dtf.withLocale(lc);
				
				LocalDate constructorVal2 = LocalDate.parse(components[3], dtf);
				
				Book bo = new Book(components[0], components[1], constructorVal, constructorVal2);
				if (!bo.getAuthor().equalsIgnoreCase(b.getAuthor()) && !bo.getTitle().equalsIgnoreCase(b.getTitle())) {
					books.add(bo); 
				}
				line = br.readLine(); 
			}
			br.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("File not created"); 
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sorry, the file is empty");  
		} 
		deleteFile(); 
		createFile();
		for (Book currBook: books) {

			writeToFile(currBook); 
		}
	}
		public static ArrayList<Book> ALFromFile() {  
			Path path = Paths.get(filePath); 
			File f = path.toFile();  
			BufferedReader br = null; 
			ArrayList <Book> books = new ArrayList<Book>(); 
			try {
				br = new BufferedReader(new FileReader(f));
				String line = br.readLine(); 
				while (line != null) {
					 
					String[] components = line.split(",");
					
					//converts to boolean and Date so that the constructor will take them. 
					boolean constructorVal = Boolean.parseBoolean(components[2]); 
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Locale lc = new Locale("EN", "US");
					dtf = dtf.withLocale(lc);
					
					LocalDate constructorVal2 = LocalDate.parse(components[3], dtf);
					
					Book b = new Book(components[0], components[1], constructorVal, constructorVal2);
					books.add(b); 
					line = br.readLine(); 
				}
				br.close(); 
			} catch (FileNotFoundException e) {
				System.out.println("File not created"); 
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Sorry, the file is empty");  
			} 
			return books; 
	
	}
	
	public static void writeToFile(Book b) {
		createFile(); 
		Path path = Paths.get(filePath); 
		File f = path.toFile();
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(f, true));
			out.println(b);
			out.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the file was not found"); 
		} 
	}
	
	public static ArrayList<Book> searchByAuthor(ArrayList<Book> books) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter the author's first or last name"); 
		String userInput = Validator.validateStringTitle(scan).toLowerCase(); 		
		
		ArrayList<Book> returnList = new ArrayList<Book>(); 
		for (Book b: books) {
			if (b.getAuthor().toLowerCase().contains(userInput)) {
				returnList.add(b); 
			}
		}
		return returnList; 
		
		
	}
	
	public static Book searchByTitle(ArrayList<Book> books) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter the book's title"); 
		String userInput = Validator.validateStringTitle(scan); 
		Book temp = null; 
		for (Book b: books) {
			if (b.getTitle().equals(userInput)) {
				temp = b; 
			}
		}
		return temp; 
		
		
	}
	
	public static void addToList(String authorName, String title) {
		 
		LocalDate date = LocalDate.now();
	
		 Book b = new Book(title, authorName, false, date); 
		writeToFile(b); 
		 
	}

}
