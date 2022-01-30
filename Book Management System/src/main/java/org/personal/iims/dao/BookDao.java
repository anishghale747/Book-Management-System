package org.personal.iims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.personal.iims.connectionfactory.ConnectionFactory;
import org.personal.iims.model.Book;

public class BookDao {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public void insertBook(Book book) throws SQLException, ClassNotFoundException {
		try {
			final String QUERY = "INSERT INTO book" + "  (book_name, book_copies) VALUES " + " (?, ?);";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, book.getBookName());
			preparedStatement.setString(2, book.getBookCopies());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Book selectBook(int id) throws ClassNotFoundException {
		Book book = null;
		try {
			final String QUERY = "select id,book_name, book_copies from book where id =?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String bookName = rs.getString("book_name");
				String bookCopies = rs.getString("book_copies");
				book = new Book(id, bookName, bookCopies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
		
	public List<Book> selectAllBooks() throws ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		try {
			final String QUERY = "select * from book";
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String bookName = rs.getString("book_name");
				String bookCopies = rs.getString("book_copies");
				books.add(new Book(id, bookName, bookCopies));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
	public boolean deleteBook(int id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		final String QUERY = "delete from book where id = ?";
		connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(QUERY);
		statement.setInt(1, id);
		rowDeleted = statement.executeUpdate() > 0;
		return rowDeleted;
	}
	
	public boolean updateBook(Book book) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		final String QUERY = "update book set book_name = ?,book_copies= ? where id = ?";
		connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(QUERY);
		statement.setString(1, book.getBookName());
		statement.setString(2, book.getBookCopies());
		statement.setInt(3, book.getId());

		rowUpdated = statement.executeUpdate() > 0;
		return rowUpdated;

	}
	
}
