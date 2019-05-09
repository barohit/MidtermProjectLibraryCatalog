package com.groupProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SearchEngine {
	
	final static String filePath = "books.txt"; 
	
	public static void readFromFile() {  
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
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
				Date constructorVal2 = sdf.parse(components[3]); 
				
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
		} catch (ParseException e) {
			System.out.println("Sorry, the date was invalid"); 
		} 
		for (Book currBook: books) {
			System.out.println(currBook); 
		
		}
	}
	
	public static void writeToFile(Book b) {
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
		System.out.println("Enter the author's last name"); 
		String userInput = Validator.validateString(scan); 
		ArrayList<Book> returnList = new ArrayList<Book>(); 
		for (Book b: books) {
			if (b.getAuthor().equals(userInput)) {
				returnList.add(b); 
			}
		}
		return returnList; 
		
		
	}
	
	public static Book searchByTitle(ArrayList<Book> books) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter the author's last name"); 
		String userInput = Validator.validateString(scan); 
		Book temp = null; 
		for (Book b: books) {
			if (b.getTitle().equals(userInput)) {
				temp = b; 
			}
		}
		return temp; 
		
		
	}
	
	public static void addToList(String authorName, String title) {
		Calendar cal = Calendar.getInstance(); 
		Date d = cal.getTime(); 
		 Book b = new Book(title, authorName, false, d); 
		writeToFile(b); 
		 
	}

}