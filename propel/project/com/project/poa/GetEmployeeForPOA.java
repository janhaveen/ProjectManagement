package com.project.poa;

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
 * Servlet implementation class GetEmployeeForPOA
 */
@WebServlet("/GetEmployeeForPOA")
public class GetEmployeeForPOA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    PreparedStatement stmt = null;
    JSONArray jArray = new JSONArray();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    int i = 1;
	    conn= MySqlConnect.DBConnection();
	    int k = 0;
	    String where="";
	    if(request.getParameter("employeeId")!=null) {
	    	where +=" AND rowId ='"+request.getParameter("employeeId")+"'";
        }
	    if(request.getParameter("statusId")!=null) {
	    	where +=" AND status ='"+request.getParameter("statusId")+"'";
	    }
	    if(request.getParameter("POAID")!=null) {
	    	where +=" AND rowId ='"+request.getParameter("POAID")+"'";
	    }
	    if(request.getParameter("projectId")!=null) {
	    	where +=" AND projectId ='"+request.getParameter("projectId")+"' or projectId=''";
	    }
	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM propel_project.poaemployeelist where 1=1 "+where;
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
				 arrayObj.put("i", i);
				 arrayObj.put("employeeId",rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("empname",rs.getString("empname")==null?"":rs.getString("empname"));				
				 i++;
				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			jsonFinal.putOnce("iTotalRecords", k);
			jsonFinal.putOnce("iTotalDisplayRecords", k);
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
