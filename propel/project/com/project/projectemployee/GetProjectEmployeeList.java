package com.project.projectemployee;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.*;

import com.data.MySql.MySqlConnect;


@WebServlet("/GetProjectEmployeeList")
public class GetProjectEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    /*
	   
	    
		if(session.getAttribute("userName") == null || session.getAttribute("userId") == null )
		{
				response.sendRedirect("index.jsp");
		}
	    */
	    String sql = "SELECT * FROM propel_project.projectemployeelist where 1=1 ";
		if(!(request.getParameter("flag") == null))
		{
			sql+=" AND rowId = '"+request.getParameter("empId")+"'";
		}
		if(!(request.getParameter("projectid") == null))
		{
			sql+=" AND projectid = '"+request.getParameter("projectid")+"'";
		}
		if(!(request.getParameter("t") == null))
		{
			if(request.getParameter("t").equals("s"))
				sql+=" AND desigText in ('Director', 'Owner');";
			if(request.getParameter("t").equals("e"))
				sql+=" AND desigText not in ('Director', 'Owner')";
		}
		
		if (!session.getAttribute("departmentTxt").equals("IT")) {
			 sql+=" AND isDeleted!=1";
		}
		if(request.getParameter("empId") != null)
		{
			sql+=" AND rowId = '"+request.getParameter("empId")+"'";
		}
		System.out.println(sql);
	    conn = MySqlConnect.DBConnection();
		
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 
				 arrayObj.put("employeeId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("ProjectId", rs.getString("ProjectId")==null?"":rs.getString("ProjectId"));
				 arrayObj.put("firstName", rs.getString("firstName")==null?"":rs.getString("firstName"));
				 arrayObj.put("lastName", rs.getString("lastName")==null?"":rs.getString("lastName"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("designation", rs.getString("designation")==null?"":rs.getString("designation"));
				 arrayObj.put("contactNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("altcontactNo", rs.getString("altcontactNo")==null?"":rs.getString("altcontactNo"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("isDeleted", rs.getString("isDeleted")==null?"":rs.getString("isDeleted"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));				 
				 arrayObj.put("reportTo", rs.getString("reportTo")==null?"":rs.getString("reportTo"));
				 arrayObj.put("experience", rs.getString("experience")==null?"":rs.getString("experience"));
				 arrayObj.put("compensation", rs.getString("compensation")==null?"":rs.getString("compensation"));
				 arrayObj.put("empname", rs.getString("empname")==null?"":rs.getString("empname"));
				 arrayObj.put("deptText", rs.getString("deptText")==null?"":rs.getString("deptText"));
				 arrayObj.put("desigText", rs.getString("desigText")==null?"":rs.getString("desigText"));

				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			out.print(jsonFinal);
			conn.close();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
