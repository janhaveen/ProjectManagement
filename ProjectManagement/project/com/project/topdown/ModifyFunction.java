package com.project.topdown;

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
import com.project.interview.Audit;

/**
 * Servlet implementation class ModifyFunction
 */
@WebServlet("/ModifyFunction")
public class ModifyFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String type="";
		DepartmentFunction f=new DepartmentFunction();
		f.setFunctionId(request.getParameter("FunctionId"));
		f.setDepartmentId(request.getParameter("DepartmentId"));
		f.setName(request.getParameter("name"));
		f.setRoleDesc(request.getParameter("RoleText"));
		f.setInfluencingFactor(request.getParameter("InfluencingFactors"));
		f.setCreatedBy(session.getAttribute("userId").toString());
		if(f.save_function(request.getParameter("action"))) {
			out.println("1");
		}else {
			out.println("10");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		String sql="";
		HttpSession session=request.getSession();
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_function where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_function SET isDeleted=1,  "
		    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
		    		+ "where rowId ='"+ request.getParameter("id") +"'";
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
