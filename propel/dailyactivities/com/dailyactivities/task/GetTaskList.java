package com.dailyactivities.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetTaskList")
public class GetTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
	    
	    String sql = "SELECT * FROM propel_support.taskDetails where 1=1 ";

	    if(request.getParameter("date")!=null)
	    {
	    	 if(!request.getParameter("date").equals("null"))
	    		 sql+="and date='"+request.getParameter("date")+"'";
	    }
	    if(session.getAttribute("designationTxt").equals("Developer"))
	    {
	    	sql+="and createdby='"+session.getAttribute("userId")+"'";
	    }
	    conn= MySqlConnect.DBConnection();
		System.out.println(sql);
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 
				 arrayObj.put("action", "<center><i class=\"select_me fa fa-check\" aria-hidden=\"true\"></i><center>" 
						 /*"<p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Edit\"><button class=\"btn btn-primary btn-xs\" data-title=\"Edit\" data-toggle=\"modal\" data-target=\"#edit\" ><i class=\"fa fa-trash fa-2x\" aria-hidden=\"true\"></i></button></p>"
				 		+ "<p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Delete\"><button class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" ><i class=\"fa fa-pencil fa-2x\" aria-hidden=\"true\"></i></button></p>"*/);
				 arrayObj.put("title", rs.getString("title")==null?"":rs.getString("title"));
				 arrayObj.put("projectName", rs.getString("projectName")==null?"":rs.getString("projectName"));
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("moduleName", rs.getString("moduleName")==null?"":rs.getString("moduleName"));
				 arrayObj.put("date", rs.getString("date")==null?"":rs.getString("date"));
				 arrayObj.put("startTime", rs.getString("startTime")==null?"":rs.getString("startTime"));
				 arrayObj.put("endTime", rs.getString("endTime")==null?"":rs.getString("endTime"));
				 arrayObj.put("assignedBy", rs.getString("assignedBy")==null?"":rs.getString("assignedBy"));
				 arrayObj.put("description", rs.getString("description")==null?"":rs.getString("description"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("startTimeToShow", rs.getString("startTimeToShow")==null?"":rs.getString("startTimeToShow"));
				 arrayObj.put("endTimeToShow", rs.getString("endTimeToShow")==null?"":rs.getString("endTimeToShow"));
				 arrayObj.put("createdByEmp", rs.getString("createdByEmp")==null?"":rs.getString("createdByEmp"));
				 arrayObj.put("duration", rs.getString("duration")==null?"":rs.getString("duration"));
				 
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
