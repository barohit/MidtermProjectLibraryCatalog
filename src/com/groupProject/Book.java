package com.groupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Book {
	
	private String title;
	private String author;
	private Boolean status;
	private Date dueDate;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDa) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null;
		try {
			d = sdf.parse(dueDa);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		this.dueDate = d;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Book(String title, String author, Boolean status, Date dueDate) {
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
