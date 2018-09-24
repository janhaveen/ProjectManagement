package com.support.issue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

@WebServlet("/IssueRegisterServlet")
public class IssueRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Issue issue = new Issue();
		
		issue.setRowId(request.getParameter("issueId"));
		issue.setProjectId(request.getParameter("selectedProjectId"));
		issue.setTitle(request.getParameter("issueTitle"));
		issue.setCategory(request.getParameter("category"));
		/*try {
			issue.setExpectedDeilveryDate(MySqlConnect.convertToSqlDate(request.getParameter("expectedDeilveryDate")));
		} catch (Exception e) {
			
		}*/
		issue.setDescription(request.getParameter("description"));
		issue.setAssignedTo(request.getParameter("assignedTo"));
		issue.setCustomer(request.getParameter("customer"));
		issue.setMode(request.getParameter("mode"));
		issue.setPriority(request.getParameter("priority"));

		issue.setCreatedby((String)session.getAttribute("userId"));
		issue.setUpdatedby((String)session.getAttribute("userId"));
		
		if (issue.newIssue()) {
			out.println("1");
		}
		else {
			out.println("0");
		}
	}
}
