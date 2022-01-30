package org.personal.iims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.personal.iims.dao.BookDao;
import org.personal.iims.dao.IssueDao;
import org.personal.iims.model.Book;
import org.personal.iims.model.IssueBook;

@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public void init(ServletConfig config) throws ServletException {
		bookDao = new BookDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			case "/issuelist":
				listIssue(request, response);
			default:
				listBook(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<Book> listBook = bookDao.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDao.selectBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		String bookName = request.getParameter("bookName");
		String bookCopies = request.getParameter("bookCopies");
		Book book = new Book(bookName, bookCopies);
		bookDao.insertBook(book);
		response.sendRedirect("list");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("bookName");
		String bookCopies = request.getParameter("bookCopies");
		Book book = new Book(id, bookName, bookCopies);
		bookDao.updateBook(book);
		response.sendRedirect("list");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookDao.deleteBook(id);
		response.sendRedirect("list");
	}

	private void listIssue(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<IssueBook> listIssue = IssueDao.viewIssuedBooks();
		request.setAttribute("listIssue", listIssue);
		RequestDispatcher dispatcher = request.getRequestDispatcher("issuelist.jsp");
		dispatcher.forward(request, response);
	}

}
