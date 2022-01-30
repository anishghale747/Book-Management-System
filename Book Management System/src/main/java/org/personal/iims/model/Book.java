package org.personal.iims.model;

public class Book {

	private int id;
	private String bookName;
	private String bookCopies;

	public Book() {

	}

	public Book(String bookName, String bookCopies) {
		super();
		this.bookName = bookName;
		this.bookCopies = bookCopies;
	}

	public Book(int id, String bookName, String bookCopies) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookCopies = bookCopies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(String bookCopies) {
		this.bookCopies = bookCopies;
	}

}
