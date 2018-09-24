package com.project.format;

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

/**
 * Servlet implementation class GetFormatList
 */
@WebServlet("/GetFormatList")
public class GetFormatList extends HttpServlet {
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
	    if(request.getParameter("ProcessId")!=null) {
	    	where +=" AND ProcessId ='"+request.getParameter("ProcessId")+"'";
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
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.formatlist where 1=1 "+where;		    
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
	    String sql = "SELECT * FROM propel_project.formatlist where 1=1 "+where;
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
				 arrayObj.put("i", i);
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("processId", rs.getString("processId")==null?"":rs.getString("processId"));
				 arrayObj.put("name", rs.getString("name")==null?"":rs.getString("name"));
				 arrayObj.put("type", rs.getString("type")==null?"":rs.getString("type"));
				 arrayObj.put("filename", rs.getString("filename")==null?"":rs.getString("filename"));
				 arrayObj.put("filepath", rs.getString("filepath")==null?"":rs.getString("filepath"));
				 arrayObj.put("createdBy", rs.getString("createdBy")==null?"":rs.getString("createdBy"));
				 arrayObj.put("updatedBy", rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
				 arrayObj.put("action", "<a class='btn-floating btn-elegant btn-sm upload' data-toggle='modal' data-target='#'><i class='fas fa-upload'></i></a>"
				 		+ "		<a class='btn-floating btn-elegant btn-sm download' data-toggle='modal' data-target='#'><i class='fas fa-download'></i></a>");
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
