package com.project.projectemployee;

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
 * Servlet implementation class RegisterEmplyee
 */
@WebServlet("/ModifyProjectEmployee")
public class ModifyProjectEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ProjectEmployee emp = new ProjectEmployee();
		
		emp.setEmployeeId(request.getParameter("EmployeeId"));
		emp.setProjectId(request.getParameter("ProjectId"));
		emp.setFirstName(request.getParameter("empFirstName"));
		emp.setLastName(request.getParameter("empLastName"));
		emp.setDepartment(request.getParameter("department"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setBranchId(request.getParameter("branch"));
		try {
			emp.setMobileNo(Long.parseLong(request.getParameter("empMobileNo")));
		} catch (Exception e) {
			emp.setMobileNo(Long.parseLong("0"));
		}
		try {
			emp.setAltContactNo(Long.parseLong(request.getParameter("altContactNo")));
		} catch (Exception e) {
			emp.setAltContactNo(Long.parseLong("0"));
		}
		emp.setEmailId(request.getParameter("empEmailID"));
		emp.setLocation(request.getParameter("empLocation"));
		emp.setReportTo(request.getParameter("empSupervisor"));
		emp.setExperience(request.getParameter("empExperience"));
		emp.setCompensation(request.getParameter("empCompensation"));
		emp.setStatus("201");/*
		emp.setUserIdEmp(request.getParameter("UserId"));
		emp.setLocation(request.getParameter("location"));
		if (request.getParameter("statuscheckbox") != null) {
			emp.setStatus("501");
		} else {
			emp.setStatus("502");
		}
		try {
			emp.setBirthday(MySqlConnect.convertToSqlDate(request.getParameter("birthDate")));
		} catch (Exception e) {
			
		}
		try {
			emp.setJoinDate(MySqlConnect.convertToSqlDate(request.getParameter("joinDate")));
		} catch (Exception e) {
			
		}
		*/
		emp.setUserId(session.getAttribute("userId").toString());
		emp.setPassword("pass123");
		
		if (emp.Employee_action(request.getParameter("action"))) {
			out.println("1");
		} else {
			out.println("0");
		}
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		HttpSession session=request.getSession();
		PreparedStatement stmt;
		String sql;
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_project_employee where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_project_employee SET isDeleted=1,"
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