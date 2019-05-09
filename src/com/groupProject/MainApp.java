package com.groupProject;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainApp {

	public static void main(String[] args) {
		
		
		System.out.println("Hello World!"); // testing

	}


	public static void checkOut (Book book) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
		if (book.getStatus() == true) {
			System.out.println("Sorry, the book is checked out"); 
		} else if (book.getStatus() == false) {
			book.setStatus(true);  
			Calendar c = Calendar.getInstance(); 
			c.add(Calendar.DAY_OF_MONTH, 14); 
			String format = sdf.format(c.getTime());
			book.setDueDate(format);
			System.out.println("You have checked out " + book.getTitle()); 
			}
		}
	
	public static void checkIn (Book book) {
		if (book.getStatus() == true) {
			book.setStatus(false); 
			System.out.println("Thank you for returning " + book.getTitle()); 
		}
	}
	

}
