package org.personal.iims.model;

public class IssueBook {

	private int id;
	private String bookName;
	private String studentName;
	private String studentNo;
	private String issueDate;

	public IssueBook() {

	}

	public IssueBook(String bookName, String studentName, String studentNo, String issueDate) {
		super();
		this.bookName = bookName;
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.issueDate = issueDate;
	}

	public IssueBook(int id, String bookName, String studentName, String studentNo, String issueDate) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.issueDate = issueDate;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

}