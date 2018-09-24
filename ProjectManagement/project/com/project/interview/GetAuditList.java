package com.project.interview;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetAuditList")
public class GetAuditList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    conn= MySqlConnect.DBConnection();
	    int k = 0;
	    int i = 1;
	    String where="";
	    if(request.getParameter("interviewid")!=null) {
	    	where +=" AND interviewId ='"+request.getParameter("interviewid")+"'";
        }
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","name", "location", "address", "pincode", "state_txt","area"};
		    List<String> search=new ArrayList<String>();
		    search.add("");
		    search.add(request.getParameter("columns[1][search][value]")==null ? "":request.getParameter("columns[1][search][value]"));
		    search.add(request.getParameter("columns[2][search][value]")==null ? "":request.getParameter("columns[2][search][value]"));
		    search.add(request.getParameter("columns[3][search][value]")==null ? "":request.getParameter("columns[3][search][value]"));
		    search.add(request.getParameter("columns[4][search][value]")==null ? "":request.getParameter("columns[4][search][value]"));
		    search.add(request.getParameter("columns[5][search][value]")==null ? "":request.getParameter("columns[5][search][value]"));
		    search.add(request.getParameter("columns[6][search][value]")==null ? "":request.getParameter("columns[6][search][value]"));
		    
			for (int j = 0; j < aColumns.length; j++) {System.out.println(search.get(j));
				if(search.get(j)!="" && search.get(j)!="null" && search.get(j)!=null)
					where +=" AND "+aColumns[j]+" like '%"+search.get(j)+"%'";
			}
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.auditlist where 1=1 "+where;		    
		    try {
				stmt1 = conn.prepareStatement(sql1);
				ResultSet rs1 = stmt1.executeQuery();
				while (rs1.next()) {
					k=Integer.parseInt(rs1.getString("total"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
	    String sql = "SELECT * FROM propel_project.auditlist where 1=1 "+where;
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
	    	sql +=" LIMIT "+ request.getParameter("start")+", "+request.getParameter("length");
	    }
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
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("InterviewId", rs.getString("InterviewId")==null?"":rs.getString("InterviewId"));
				 arrayObj.put("influencingFactor", rs.getString("influencingFactor")==null?"":rs.getString("influencingFactor"));
				 arrayObj.put("currentMetric", rs.getString("currentMetric")==null?"":rs.getString("currentMetric"));
				 arrayObj.put("metricType", rs.getString("metricType")==null?"":rs.getString("metricType"));
				 arrayObj.put("comments", rs.getString("comments")==null?"":rs.getString("comments"));
				 arrayObj.put("metricType_txt", rs.getString("metricType_txt")==null?"":rs.getString("metricType_txt"));
				 jArray.put(arrayObj);
				 i++;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
