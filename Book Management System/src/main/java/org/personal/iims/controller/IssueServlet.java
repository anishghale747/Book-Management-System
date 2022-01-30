package org.personal.iims.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.personal.iims.dao.IssueDao;

@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IssueDao issueDao;
   
	public void init(ServletConfig config) throws ServletException {
		issueDao = new IssueDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
