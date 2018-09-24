package com.support.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

@WebServlet("/IssueUpdateServlet")
public class IssueUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Issue issue = new Issue();
		
		issue.setRowId(request.getParameter("selectedIssueId"));
		issue.setProjectId(request.getParameter("selectedProjectId"));
		issue.setTitle(request.getParameter("issueTitle"));
		issue.setCategory(request.getParameter("category"));
		
		issue.setDescription(request.getParameter("description"));
		issue.setRemarks(request.getParameter("remarks"));
		issue.setAssignedTo(request.getParameter("assignedTo"));
		issue.setCustomer(request.getParameter("customer"));
		issue.setMode(request.getParameter("mode"));
		issue.setPriority(request.getParameter("priority"));
		issue.setIsAccepted(Integer.parseInt(request.getParameter("status")));
		if(request.getParameter("status").equals("1"))
		{
			if(request.getParameter("expectedStartDate") != null)
			{
				issue.setExpectedStartDate(MySqlConnect.convertToSqlDate(request.getParameter("expectedStartDate")));
			}
			issue.setDuration(request.getParameter("duration"));
		}
		
		issue.setStartDate(new Date(System.currentTimeMillis()));
		issue.setEndDate(new Date(System.currentTimeMillis()));

		issue.setCreatedby((String)session.getAttribute("userId"));
		issue.setUpdatedby((String)session.getAttribute("userId"));
		
		if(request.getParameter("type").equals("support"))
		{
			if (issue.updateIssueSupport()) {
				out.println("1");
			}
			else {
				out.println("0");
			}
		}
		else if(request.getParameter("updateDate").equals("updateStart"))
		{
			if (issue.updateStartDate())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("updateDate").equals("updateEnd"))
		{
			if (issue.updateEndDate())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else
		{
			if (issue.updateIssue())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
	}
}
