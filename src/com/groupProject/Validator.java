package com.groupProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

	public static int validateInt (Scanner scan)  {
		boolean validInput = false; 
		int userInput = 0; 
		
		while (validInput == false) {
			try {
				userInput = scan.nextInt();
				if (userInput < 0 || userInput > 4) {
					throw new IllegalArgumentException();  
				}
				validInput = true; 
			} catch (InputMismatchException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine();  
				continue; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return userInput; 
	}
	
	public static long validateLong (Scanner scan)  {
		boolean validInput = false; 
		long userInput = 0; 
		
		while (validInput == false) {
			try {
				userInput = scan.nextInt();
				validInput = true; 
			} catch (InputMismatchException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine();  
				continue; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return userInput; 
	}
	
	public static int validateChoice (Scanner scan)  {
		int year = 0; 
		boolean validInput = false; 
		while (validInput == false) {
			try {
				year = validateInt(scan); 
				if (year < 1 || year > 7) {
					throw new IllegalArgumentException(); 
				} 
				validInput = true; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return year; 
	}
	
	public static char validateChar (Scanner scan) {
		char ans = 'n'; 
		boolean validInput = false; 
		while (validInput == false) {
			try {
				ans = Character.toLowerCase(scan.next().charAt(0)); 
				if (ans != 'y' && ans != 'n') {
					throw new IllegalArgumentException(); 
				} 
				validInput = true; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return ans; 
	}
	public static int validateYear (Scanner scan)  {
		int year = 0; 
		boolean validInput = false; 
		while (validInput == false) {
			try {
				year = validateInt(scan); 
				if (year < 1920 || year > 2020) {
					throw new IllegalArgumentException(); 
				} 
				validInput = true; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return year; 
	}
	
	public static double validateDouble (Scanner scan)  {
		boolean validInput = false; 
		double userInput = 0.0; 
		
		while (validInput == false) { 
			try {
				userInput = scan.nextDouble(); 
				if (userInput < 0.0) {
					throw new IllegalArgumentException();  
				}
				validInput = true; 
			} catch (InputMismatchException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine();
				continue; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: ");  
				scan.nextLine();
				continue; 
			}
		}
		return userInput; 
	}
	
	public static String validateString (Scanner scan) {
		boolean validInput = false; 
		String userInput = "";  
		while (validInput == false) { 
			try { 
				userInput = scan.nextLine();
				for (int i = 0; i < userInput.length(); i++) {
					if (!(Character.isAlphabetic(userInput.charAt(i)) || Character.isWhitespace(userInput.charAt(i)))) {
						throw new IllegalArgumentException(); 
					}
				}
				validInput = true; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: ");  
				scan.nextLine();
				continue; 
			}
		}
		return userInput; 
	}
	
	public static String validateGameChoice (Scanner scan) {
		String userInput = validateString(scan); 
		while (!(userInput.equalsIgnoreCase("Rock") || userInput.equalsIgnoreCase("Paper") || userInput.equalsIgnoreCase("Scissors")) ) {
			System.out.println("Sorry, invalid input. Please enter 'Rock', 'Paper', or 'Scissors' again: "); 
			userInput = validateString(scan); 
		}
		return userInput; 
	}
	

	
	public static char validateGameChoice2 (Scanner scan) {
		char ans = 'n'; 
		boolean validInput = false; 
		while (validInput == false) {
			try {
				ans = Character.toLowerCase(scan.next().charAt(0)); 
				if (ans != 'j' && ans != 's') {
					throw new IllegalArgumentException(); 
				} 
				validInput = true; 
			} catch (IllegalArgumentException e) {
				System.out.println("Error, invalid input. Please try again: "); 
				scan.nextLine(); 
				continue; 
			}
		}
		return ans; 
	}
}
