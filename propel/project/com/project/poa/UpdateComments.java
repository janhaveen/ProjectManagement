package com.project.poa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.system.GetSystemDetails;


@WebServlet("/UpdateComments")
public class UpdateComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date d1=new Date(System.currentTimeMillis());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis());
		//PlanOfAction poa=new PlanOfAction();	
		PlanOfActionLog poal=new PlanOfActionLog();
		
		poal.setRowId(UUID.randomUUID().toString());
		poal.setPlanOfActionId(request.getParameter("planofactionId"));
		poal.setAction("200006");
		//poal.setFromValue(request.getParameter("commentsOld"));
		//poal.setToValue(request.getParameter("comments"));
		poal.setComment(request.getParameter("comments"));
		poal.setCreatedBy(session.getAttribute("userId").toString());
		logEntry = poal.save_PlanOfActionLog();
		
		if(logEntry)
			out.println("1");
		else
			out.println("0");
	}
}
