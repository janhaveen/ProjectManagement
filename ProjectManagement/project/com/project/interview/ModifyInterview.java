package com.project.interview;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class CreateInterview
 */
@WebServlet("/ModifyInterview")
public class ModifyInterview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Interview i=new Interview();
		
		i.setInterviewId(request.getParameter("InterviewId"));
		i.setProjectId(request.getParameter("ProjectId"));
		i.setEmployeeId(request.getParameter("EmployeeId"));
		i.setMeeting(request.getParameter("meeting"));
		i.setCoaching(request.getParameter("coaching"));
		i.setTraining(request.getParameter("training"));
		i.setRole(request.getParameter("empRole"));
		i.setChallenges(request.getParameter("obChallenges"));
		i.setCreatedBy(session.getAttribute("userId").toString());
		
		if(i.save_interView(request.getParameter("action")))
			out.println("1");
		else
			out.println("0");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		String sql="";
		HttpSession session=request.getSession();
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_interview where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_interview SET isDeleted=1,"
		    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
		    		+ " where rowId ='"+ request.getParameter("id") +"'";
		}
		System.out.print(sql);
		try {
			stmt = conn.prepareStatement(sql);
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
			}
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
