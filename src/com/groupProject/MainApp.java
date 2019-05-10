package com.groupProject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		String userAnswer1;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> menu = new ArrayList<>();
		menu.add("1. List of books");
		menu.add("2. Search for a book");
		menu.add("3. Add a book");
		menu.add("4. Exit program");
		char continuing = 'y';
		while (continuing =='y') {
			for (int i = 0; i < menu.size(); i++) {
				System.out.println(menu.get(i));
			}
	
			System.out.println("Please pick the number of the task you would like to complete");
			int userAnswer = Validator.validateInt(scan);
			scan.nextLine();
	
			if (userAnswer == 1) {
				SearchEngine.readFromFile();
				continue; 
	
			} else if (userAnswer == 2) {
				System.out.println("Would you like to search by author or title");
				userAnswer1 = Validator.validateStringTitle(scan);
				Book result = null; 
				
				if (userAnswer1.equalsIgnoreCase("Author")) {
					ArrayList<Book> authorBooks = new ArrayList<Book>();
					authorBooks = SearchEngine.searchByAuthor(SearchEngine.ALFromFile());
					if (authorBooks.size() > 1) {
						System.out.println("Which is your choice? They are numbered in the order listed: "); 
						for (Book b : authorBooks) {
							System.out.println(b);
						}
						int userAnswer2 = Validator.
								validateInt(scan); 
						boolean validInput = false; 
						
						while (validInput == false) {
							try {
								result = authorBooks.get(userAnswer2 - 1); 
								validInput = true; 
							} catch (IndexOutOfBoundsException e) {
								System.out.println("Sorry, invalid input. Please try again: ");  
								continue;  
							}
	
						}		
					}
					else if (authorBooks.size() ==  1) {
						result = authorBooks.get(0); 
					} else {
						try {
						throw new IndexOutOfBoundsException(); 
						} catch (IndexOutOfBoundsException e) {
						System.out.println("Sorry, nothing was found"); 
					}
				}} else if (userAnswer1.equalsIgnoreCase("Title")) {
					result = SearchEngine.searchByTitle(SearchEngine.ALFromFile());
				} else {
					System.out.println("Answer not recongized");
				}
				try {
				checkOut(result); 
				} catch (NullPointerException e) {
					System.out.println("Sorry, nothing was found"); 
				}
				continue; 
			} else if (userAnswer == 3) {
				System.out.println("Enter an author name"); 
				String an = Validator.validateStringTitle(scan); 
				System.out.println("Enter a title");  
				String tl = Validator.validateStringTitle(scan); 
				SearchEngine.addToList(an, tl); 
				continue; 
			} else if (userAnswer == 4) {
				System.out.println("Have a nice day!"); 
				continuing = 'n'; 
			} else {
				System.out.println("Input not found please enter something new");
				continue; 
			}
	}
}

	public static void checkOut(Book book) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		if (book.getStatus() == true) {
			System.out.println("Sorry, the book is checked out");
		} else if (book.getStatus() == false) {
			book.setStatus(true);
			LocalDate today = LocalDate.now(); 
			 LocalDate twoWeeksLater = today.plus(2, ChronoUnit.WEEKS);
			 book.setDueDateDate(twoWeeksLater);
			System.out.println("You have checked out " + book.getTitle());
		}
	}

	public static void checkIn(Book book) {
		if (book.getStatus() == true) {
			book.setStatus(false);
			System.out.println("Thank you for returning " + book.getTitle());
		}
	}

}
