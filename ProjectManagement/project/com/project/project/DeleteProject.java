package com.project.project;

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
 * Servlet implementation class DeleteProject
 */
@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		HttpSession session=request.getSession();
		String sql="";
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_project where rowId ='"+ request.getParameter("DeletePrId") +"'";
		}else {
			sql="UPDATE propel_project.d_project SET isDeleted=1 ,"
	    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
				+ "where rowId ='"+ request.getParameter("DeletePrId") +"'";
		}
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
