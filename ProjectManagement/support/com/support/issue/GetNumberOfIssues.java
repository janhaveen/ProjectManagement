package com.support.issue;

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

@WebServlet("/GetNumberOfIssues")
public class GetNumberOfIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    HttpSession session = request.getSession();
	    
	    String sql = "SELECT * FROM propel_support.gettotalno where 1=1 ";
	    
	    if(request.getParameter("projectId")!=null)
	    {
	    	sql+="and projectId = '"+request.getParameter("projectId")+"'";
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

				 arrayObj.put("totalsupport", rs.getString("totalsupport")==null?"":rs.getString("totalsupport"));
				 arrayObj.put("totalpendingrequest", rs.getString("totalpendingrequest")==null?"":rs.getString("totalpendingrequest"));
				 arrayObj.put("totalinprocessrequest", rs.getString("totalinprocessrequest")==null?"":rs.getString("totalinprocessrequest"));
				 arrayObj.put("totalcompletedrequest", rs.getString("totalcompletedrequest")==null?"":rs.getString("totalcompletedrequest"));
				 arrayObj.put("totalonholdrequest", rs.getString("totalonholdrequest")==null?"":rs.getString("totalonholdrequest"));
				 arrayObj.put("totalpendingissue", rs.getString("totalpendingissue")==null?"":rs.getString("totalpendingissue"));
				 arrayObj.put("totalinprocessissue", rs.getString("totalinprocessissue")==null?"":rs.getString("totalinprocessissue"));
				 arrayObj.put("totalcompletedissue", rs.getString("totalcompletedissue")==null?"":rs.getString("totalcompletedissue"));
				 arrayObj.put("totalonholdissue", rs.getString("totalonholdissue")==null?"":rs.getString("totalonholdissue"));
				 arrayObj.put("totaldisapproved", rs.getString("totaldisapproved")==null?"":rs.getString("totaldisapproved"));
//				 arrayObj.put("projectId", rs.getString("projectId")==null?"":rs.getString("projectId"));
				 
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
