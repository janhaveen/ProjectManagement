package com.dailyactivities.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Task task = new Task();
		
		task.setRowId(request.getParameter("taskId"));
		task.setProjectName(request.getParameter("projectName"));
		task.setModuleName(request.getParameter("module"));
		task.setDate(MySqlConnect.convertFromattedDate(request.getParameter("date")));
		task.setStartTime(MySqlConnect.convertTime(request.getParameter("startTime")));
		task.setEndTime(MySqlConnect.convertTime(request.getParameter("endTime")));
		task.setAssignedBy(request.getParameter("assignedBy"));
		task.setDescription(request.getParameter("description"));
		task.setStatus(request.getParameter("status"));
		task.setCreatedBy((String)session.getAttribute("userId"));
		task.setUpdatedBy((String)session.getAttribute("userId"));
		
		if (task.updateTask()) {
			out.println("1");
		} else {
			out.println("0");
		}
	}
}
