package org.personal.iims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.personal.iims.connectionfactory.ConnectionFactory;
import org.personal.iims.model.IssueBook;

public class IssueDao {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	public static List<IssueBook> viewIssuedBooks() {
		List<IssueBook> list = new ArrayList<IssueBook>();
		try {
			final String QUERY = "select * from issuebook";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				IssueBook book = new IssueBook();
				book.setId(resultSet.getInt("id"));
				book.setBookName(resultSet.getString("book_name"));
				book.setStudentName(resultSet.getString("studentname"));
				book.setStudentNo(resultSet.getString("studentno"));
				book.setIssueDate(resultSet.getString("issuedate"));
				list.add(book);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
