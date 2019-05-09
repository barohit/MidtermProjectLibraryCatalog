package com.groupProject;

import java.text.SimpleDateFormat;
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
		menu.add("3. add a book");
		menu.add("4. Check book out");
		menu.add("5. Exit program");
		for (int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i));
		}

		System.out.println("Please pick the number of the task you would like to complete");
		int userAnswer = scan.nextInt();
		scan.nextLine();

		if (userAnswer == 1) {
			SearchEngine.readFromFile();

		} else if (userAnswer == 2) {
			System.out.println("Would you like to search by author or title");
			userAnswer1 = scan.nextLine();
			if (userAnswer1.equalsIgnoreCase("Author")) {
				ArrayList<Book> authorBooks = new ArrayList<Book>();
				authorBooks = SearchEngine.searchByAuthor(SearchEngine.ALFromFile());
				if (authorBooks.size() > 1) {
					for (Book b : authorBooks) {
						System.out.println(b);
					}

				}
			} else if (userAnswer1.equalsIgnoreCase("Title")) {
				SearchEngine.searchByTitle(SearchEngine.ALFromFile());
			} else {
				System.out.println("Answer not recongized");
			}
		} else if (userAnswer == 3) {

		} else if (userAnswer == 4) {

		} else if (userAnswer == 5) {

		} else {
			System.out.println("Input not found please enter something new");
		}
	}

	public static void checkOut(Book book) {
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

	public static void checkIn(Book book) {
		if (book.getStatus() == true) {
			book.setStatus(false);
			System.out.println("Thank you for returning " + book.getTitle());
		}
	}

}
