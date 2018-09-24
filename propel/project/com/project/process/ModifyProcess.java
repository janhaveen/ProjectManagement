package com.project.process;

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
 * Servlet implementation class CreateProcess
 */
@WebServlet("/ModifyProcess")
public class ModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Process p=new Process();
		
		p.setProcessId(request.getParameter("ProcessId"));
		p.setProjectId(request.getParameter("ProjectId"));
		p.setInterviewId(request.getParameter("InterviewId"));
		p.setProcessName(request.getParameter("procedureTitle"));
		p.setDepartment(request.getParameter("department"));
		p.setProcessDocType(request.getParameter("processDocType"));
		p.setProcedureComments(request.getParameter("procedureComments"));
		p.setSupplier(request.getParameter("supplier"));
		p.setInput(request.getParameter("inputText"));
		p.setProcess(request.getParameter("processText"));
		p.setOutput(request.getParameter("outputText"));
		p.setCustomer(request.getParameter("customer"));
		p.setCreatedBy(session.getAttribute("userId").toString());
		
		if(p.save_process(request.getParameter("action")))
			out.println("1");
		else
			out.println("0");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		HttpSession session=request.getSession();
		PreparedStatement stmt;
		String sql;
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_process where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_process SET isDeleted=1,"
		    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
		    		+ " where rowId ='"+ request.getParameter("id") +"'";
		}System.out.print(sql);
		try {
			stmt = conn.prepareStatement(sql);
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
			}
			
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
