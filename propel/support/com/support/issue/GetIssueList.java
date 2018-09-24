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

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetIssueList")
public class GetIssueList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    String sql = "";
	    if(request.getParameter("projectId")!=null)
	    {
		    sql = "SELECT * FROM propel_support.issueToShow where 1=1";
	    }

	    if(request.getParameter("projectId")!=null)
	    {
		    if(request.getParameter("projectId").equals(""))
		    {
		    	sql+=" projectId = '"+request.getParameter("projectId")+"' ";
		    }
	    }
	    if(request.getParameter("type")!=null)
	    {
		    switch (request.getParameter("type")) {
			case "support":
				sql += " and typeOfIssue = 'Support'";
				break;
			case "pendingRequest":
				sql += " and requestpending = 1";
				break;
			case "inProcessRequest":
				sql += " and requestInProcess = 1";
				break;
			case "completedRequest":
				sql += " and requestCompleted = 1";
				break;
			case "onHoldRequest":
				sql += " and requestOnHold = 1";
				break;
			case "disapprovedRequest":
				sql += " and isAccepted = 2";
				break;
			case "pendingIssue":
				sql += " and issuepending = 1";
				break;
			case "inProcessIssue":
				sql += " and issueInProcess = 1";
				break;
			case "completedIssue":
				sql += " and issueCompleted = 1";
				break;
			case "onHoldIssue":
				sql += " and issueOnHold = 1";
				break;
			case "allIssueList":
				sql = "SELECT * FROM propel_support.issueToShow where category = 100003";
				break;
			case "allSupportList":
				sql = "SELECT * FROM propel_support.issueToShow where category = 100001";
				break;
			case "allRequestList":
				sql = "SELECT * FROM propel_support.issueToShow where category = 100002";
				break;

			default:
				break;
			}
	    }
	    
	    conn= MySqlConnect.DBConnection();
		
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt = conn.prepareStatement(sql);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();

				 arrayObj.put("rowid", rs.getString("rowid")==null?"":rs.getString("rowid"));
				 arrayObj.put("projectId", rs.getString("projectId")==null?"":rs.getString("projectId"));
				 arrayObj.put("title", rs.getString("title")==null?"":rs.getString("title"));
				 arrayObj.put("category", rs.getString("category")==null?"":rs.getString("category"));
				 arrayObj.put("mode", rs.getString("mode")==null?"":rs.getString("mode"));
				 arrayObj.put("priority", rs.getString("priority")==null?"":rs.getString("priority"));
				 arrayObj.put("assignedTo", rs.getString("assignedTo")==null?"":rs.getString("assignedTo"));
				 arrayObj.put("formattedexpectedStartDate", rs.getString("formattedexpectedStartDate")==null?"":rs.getString("formattedexpectedStartDate"));
				 arrayObj.put("duration", rs.getString("duration")==null?"":rs.getString("duration"));
				 arrayObj.put("assignedToName", rs.getString("assignedToName")==null?"":rs.getString("assignedToName"));
				 arrayObj.put("customer", rs.getString("customer")==null?"":rs.getString("customer"));
				 arrayObj.put("description", rs.getString("description")==null?"":rs.getString("description"));
				 arrayObj.put("isAccepted", rs.getString("isAccepted")==null?"":rs.getString("isAccepted"));
				 arrayObj.put("startDate", rs.getString("startDate")==null?"":rs.getString("startDate"));
				 arrayObj.put("endDate", rs.getString("endDate")==null?"":rs.getString("endDate"));
				 arrayObj.put("remarks", rs.getString("remarks")==null?"":rs.getString("remarks"));
				 
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
