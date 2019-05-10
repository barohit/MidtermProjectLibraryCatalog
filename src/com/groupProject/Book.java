package com.groupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Book {
	
	private String title;
	private String author;
	private Boolean status;
	private LocalDate dueDate;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDa) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		Locale lc = new Locale("EN", "US");
		dtf = dtf.withLocale(lc);
		
		LocalDate d = LocalDate.parse(dueDa, dtf);
		this.dueDate = d;
		
	}
	
	public void setDueDateDate(LocalDate dueDa) {
		
		this.dueDate =  dueDa;
		
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Book(String title, String author, Boolean status, LocalDate dueDate) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return title + "," + author+ "," + status + ","+ dueDate ;
	}
	public Book() {
		

		
	}
	
	
	
	
	
	

}
