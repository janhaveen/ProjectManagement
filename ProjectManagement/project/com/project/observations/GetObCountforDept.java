package com.project.observations;

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

/**
 * Servlet implementation class GetPoaCountforStatus
 */
@WebServlet("/GetObCountforDept")
public class GetObCountforDept extends HttpServlet {
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
	    String sql ="";
	    if(request.getParameter("projectid")!=null) {
	    	sql +="SELECT * FROM propel_project.obcountforDeptbyproject where 1=1 ";
	    	sql +=" AND projectid ='"+request.getParameter("projectid")+"'";
        }else {
        	 sql = "SELECT * FROM propel_project.poacountforstatus where 1=1 ";
        }
	    if(request.getParameter("type")!=null) {
	    	sql+=" AND status_txt='"+request.getParameter("type")+"'";
	    }
	    System.out.println(sql);
	    conn= MySqlConnect.DBConnection();
		
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("total", rs.getString("total")==null?"":rs.getString("total"));
				 arrayObj.put("dept_txt", rs.getString("dept_txt")==null?"":rs.getString("dept_txt"));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
