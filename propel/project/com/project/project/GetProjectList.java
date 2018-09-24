package com.project.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class GetProjectList
 */
@WebServlet("/GetProjectList")
public class GetProjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    PreparedStatement stmt = null;
    JSONArray jArray = new JSONArray();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    
	    conn= MySqlConnect.DBConnection();
	    int k = 0;
	    String where="";
	    HttpSession session = request.getSession();
		if (session.getAttribute("userName") == null) {
			response.setStatus(302);
			response.sendRedirect("index.jsp?page=timeout");
		}
	    if (!session.getAttribute("departmentTxt").equals("Management") && !session.getAttribute("departmentTxt").equals("IT")) {
			
		}

		if (!session.getAttribute("departmentTxt").equals("IT")) {
			where+=" AND isDeleted!=1";
		}
	    if(request.getParameter("viewOnly")!=null) {
	    	if(request.getParameter("viewOnly").equals("m"))
	    		where +=" AND cpc='"+session.getAttribute("userId")+"'";
	    	else 
	    		where +=" AND epc='"+session.getAttribute("userId")+"'";
	    }
	    if(request.getParameter("projectid")!=null) {	    	
	    	where +=" AND rowid='"+request.getParameter("projectid")+"'";
	    }
	    
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","rowid","companyName","location","stakeholderName", "phoneNo", "emailId", "cpc", "epc"};
		    List<String> search=new ArrayList<String>();
		    search.add("");
		    search.add(request.getParameter("columns[1][search][value]")==null ? "":request.getParameter("columns[1][search][value]"));
		    search.add(request.getParameter("columns[2][search][value]")==null ? "":request.getParameter("columns[2][search][value]"));
		    search.add(request.getParameter("columns[3][search][value]")==null ? "":request.getParameter("columns[3][search][value]"));
		    search.add(request.getParameter("columns[4][search][value]")==null ? "":request.getParameter("columns[4][search][value]"));
		    search.add(request.getParameter("columns[5][search][value]")==null ? "":request.getParameter("columns[5][search][value]"));
		    search.add(request.getParameter("columns[6][search][value]")==null ? "":request.getParameter("columns[6][search][value]"));
		    search.add(request.getParameter("columns[7][search][value]")==null ? "":request.getParameter("columns[7][search][value]"));
		    search.add(request.getParameter("columns[8][search][value]")==null ? "":request.getParameter("columns[8][search][value]"));
		    search.add(request.getParameter("columns[9][search][value]")==null ? "":request.getParameter("columns[9][search][value]"));
		    
			for (int j = 0; j < aColumns.length; j++) {System.out.println(search.get(j));
				if(search.get(j)!="" && search.get(j)!="null" && search.get(j)!=null)
					where +=" AND "+aColumns[j]+" like '%"+search.get(j)+"%'";
			}
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.projectlist where 1=1 "+where;		    
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
	    String sql = "SELECT * FROM propel_project.projectlist where 1=1 "+where;
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
	    	sql +=" LIMIT "+ request.getParameter("start")+", "+request.getParameter("length");
	    }
	    //System.out.println(sql+" nnmjmm");
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 arrayObj.put("rowid", rs.getString("rowid")==null?"":rs.getString("rowid"));
				 arrayObj.put("companyName", rs.getString("companyName")==null?"":rs.getString("companyName"));
				 arrayObj.put("branchName", rs.getString("branchName")==null?"":rs.getString("branchName"));
				 arrayObj.put("referenceBy", rs.getString("referenceBy")==null?"":rs.getString("referenceBy"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("stakeholderName", rs.getString("stakeholderName")==null?"":rs.getString("stakeholderName"));
				 arrayObj.put("industry", rs.getString("industry")==null?"":rs.getString("industry"));
				 arrayObj.put("phoneNo", rs.getString("phoneNo")==null?"":rs.getString("phoneNo"));
				 arrayObj.put("website", rs.getString("website")==null?"":rs.getString("website"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("stakeholderFname", rs.getString("stakeholderFname")==null?"":rs.getString("stakeholderFname"));
				 arrayObj.put("stakeholderLname", rs.getString("stakeholderLname")==null?"":rs.getString("stakeholderLname"));
				 arrayObj.put("stakeholderDesignation", rs.getString("stakeholderDesignation")==null?"":rs.getString("stakeholderDesignation"));
				 arrayObj.put("stakeholderContactno", rs.getString("stakeholderContactno")==null?"":rs.getString("stakeholderContactno"));
				 arrayObj.put("stakeholderAltcontactno", rs.getString("stakeholderAltcontactno")==null?"":rs.getString("stakeholderAltcontactno"));
				 arrayObj.put("stakeholderEmailid", rs.getString("stakeholderEmailid")==null?"":rs.getString("stakeholderEmailid"));
				 arrayObj.put("billAmount", rs.getString("billAmount")==null?"":rs.getString("billAmount"));
				 arrayObj.put("paymentMode", rs.getString("paymentMode")==null?"":rs.getString("paymentMode"));
				 arrayObj.put("paymentFrequency", rs.getString("paymentFrequency")==null?"":rs.getString("paymentFrequency"));
				 arrayObj.put("gstNo", rs.getString("gstNo")==null?"":rs.getString("gstNo"));
				 arrayObj.put("address1", rs.getString("address1")==null?"":rs.getString("address1"));
				 arrayObj.put("address2", rs.getString("address2")==null?"":rs.getString("address2"));
				 arrayObj.put("areaCity", rs.getString("areaCity")==null?"":rs.getString("areaCity"));
				 arrayObj.put("state", rs.getString("state")==null?"":rs.getString("state"));
				 arrayObj.put("pincode", rs.getString("pincode")==null?"":rs.getString("pincode"));
				 arrayObj.put("startdate", rs.getString("startdate")==null?"":rs.getString("startdate"));
				 arrayObj.put("visitfrequency", rs.getString("visitfrequency")==null?"":rs.getString("visitfrequency"));
				 arrayObj.put("cpc", rs.getString("cpc")==null?"":rs.getString("cpc"));
				 arrayObj.put("epc", rs.getString("epc")==null?"":rs.getString("epc"));			
				 arrayObj.put("createdBy", rs.getString("createdBy")==null?"":rs.getString("createdBy"));
				 arrayObj.put("updatedBy", rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
				 arrayObj.put("createdOn", rs.getString("createdOn")==null?"":rs.getString("createdOn"));
				 arrayObj.put("updatedOn", rs.getString("updatedOn")==null?"":rs.getString("updatedOn"));
				 arrayObj.put("stakeholderDesignation_txt", rs.getString("stakeholderDesignation_txt")==null?"":rs.getString("stakeholderDesignation_txt"));
				 arrayObj.put("paymentMode_txt", rs.getString("paymentMode_txt")==null?"":rs.getString("paymentMode_txt"));
				 arrayObj.put("paymentFrequency_txt", rs.getString("paymentFrequency_txt")==null?"":rs.getString("paymentFrequency_txt"));
				 arrayObj.put("state_txt", rs.getString("state_txt")==null?"":rs.getString("state_txt"));
				 arrayObj.put("visitfrequency_txt", rs.getString("visitfrequency_txt")==null?"":rs.getString("visitfrequency_txt"));
				 arrayObj.put("cpc_txt", rs.getString("cpc_txt")==null?"":rs.getString("cpc_txt"));
				 arrayObj.put("epc_txt", rs.getString("epc_txt")==null?"":rs.getString("epc_txt"));
				 arrayObj.put("source", rs.getString("source")==null?"":rs.getString("source"));
				 arrayObj.put("preferredDay", rs.getString("preferredDay")==null?"":rs.getString("preferredDay"));
				 arrayObj.put("stage","");
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
