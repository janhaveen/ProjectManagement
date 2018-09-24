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
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class GetFormatList
 */
@WebServlet("/GetInterviewList")
public class GetInterviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    PreparedStatement stmt = null;
    JSONArray jArray = new JSONArray();
	private int i;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    i=1;
	    conn= MySqlConnect.DBConnection();
	    int k = 0;
	    String where="";
	    if(request.getParameter("projectid")!=null) {
	    	where+= " AND projectId='"+request.getParameter("projectid")+"'";
	    }
	    HttpSession session=request.getSession();
		if (!session.getAttribute("departmentTxt").equals("IT")) {
			where+=" AND isDeleted!=1";
		}
	    
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","rowid","createdOn","projectName","projectName", "empName", "role1", "createdBy_txt"};
		    List<String> search=new ArrayList<String>();
		    search.add("");
		    search.add(request.getParameter("columns[1][search][value]")==null ? "":request.getParameter("columns[1][search][value]"));
		    search.add(request.getParameter("columns[2][search][value]")==null ? "":request.getParameter("columns[2][search][value]"));
		    search.add(request.getParameter("columns[3][search][value]")==null ? "":request.getParameter("columns[3][search][value]"));
		    search.add(request.getParameter("columns[4][search][value]")==null ? "":request.getParameter("columns[4][search][value]"));
		    search.add(request.getParameter("columns[5][search][value]")==null ? "":request.getParameter("columns[5][search][value]"));
		    search.add(request.getParameter("columns[6][search][value]")==null ? "":request.getParameter("columns[6][search][value]"));
		    search.add(request.getParameter("columns[7][search][value]")==null ? "":request.getParameter("columns[7][search][value]"));
		    
			for (int j = 0; j < aColumns.length; j++) {System.out.println(search.get(j));
				if(search.get(j)!="" && search.get(j)!="null" && search.get(j)!=null)
					where +=" AND "+aColumns[j]+" like '%"+search.get(j)+"%'";
			}
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.interviewList where 1=1 "+where;		    
		    try {
				stmt = conn.prepareStatement(sql1);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					k=Integer.parseInt(rs.getString("total"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
	    String sql = "SELECT * FROM propel_project.interviewList where 1=1 "+where;
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
	    	sql +=" LIMIT "+ request.getParameter("start")+", "+request.getParameter("length");
	    }
	    System.out.println(sql+" nnmjmm");
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
				 arrayObj.put("projectId", rs.getString("projectId")==null?"":rs.getString("projectId"));
				 arrayObj.put("employeeid", rs.getString("employeeid")==null?"":rs.getString("employeeid"));
				 arrayObj.put("projectName", rs.getString("projectName")==null?"":rs.getString("projectName"));
				 arrayObj.put("empName", rs.getString("empName")==null?"":rs.getString("empName"));
				 arrayObj.put("EmployeeId", rs.getString("EmployeeId")==null?"":rs.getString("EmployeeId"));				 
			 	 arrayObj.put("meeting", rs.getString("meeting")==null?"":rs.getString("meeting"));
				 arrayObj.put("coaching", rs.getString("coaching")==null?"":rs.getString("coaching"));
				 arrayObj.put("training", rs.getString("training")==null?"":rs.getString("training"));
				 arrayObj.put("meeting_txt", rs.getString("meeting_txt")==null?"":rs.getString("meeting_txt"));
				 arrayObj.put("coaching_txt", rs.getString("coaching_txt")==null?"":rs.getString("coaching_txt"));
				 arrayObj.put("training_txt", rs.getString("training_txt")==null?"":rs.getString("training_txt"));
				 arrayObj.put("role1", rs.getString("role1")==null?"":rs.getString("role1"));
				 arrayObj.put("createdOn", rs.getString("createdOn")==null?"":rs.getString("createdOn"));
				 arrayObj.put("createdBy_txt", rs.getString("createdBy_txt")==null?"":rs.getString("createdBy_txt"));
				 arrayObj.put("action", "<a class='btn-floating btn-elegant btn-sm' data-toggle='modal' data-target='#'><i class='fas fa-download'></i>");
				 arrayObj.put("firstName", rs.getString("firstName")==null?"":rs.getString("firstName"));
				 arrayObj.put("lastName", rs.getString("lastName")==null?"":rs.getString("lastName"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("designation", rs.getString("designation")==null?"":rs.getString("designation"));
				 arrayObj.put("contactNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("altcontactNo", rs.getString("altcontactNo")==null?"":rs.getString("altcontactNo"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("reportTo", rs.getString("reportTo")==null?"":rs.getString("reportTo"));
				 arrayObj.put("experience", rs.getString("experience")==null?"":rs.getString("experience"));
				 arrayObj.put("compensation", rs.getString("compensation")==null?"":rs.getString("compensation"));
				 arrayObj.put("designation_txt", rs.getString("designation_txt")==null?"":rs.getString("designation_txt"));
				 arrayObj.put("department_txt", rs.getString("department_txt")==null?"":rs.getString("department_txt"));
				 arrayObj.put("challenges", rs.getString("challenges")==null?"":rs.getString("challenges"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 
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
