package com.project.observations;

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

@WebServlet("/GetObservationList")
public class GetObservationList extends HttpServlet {
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
	    	where +=" AND projectid ='"+request.getParameter("projectid")+"'";
        }
	    if(request.getParameter("ProcessId")!=null) {
	    	where +=" AND ProcessId ='"+request.getParameter("ProcessId")+"'";
        }
	    if(request.getParameter("ObservationDeptId")!=null) {
	    	if(request.getParameter("ObservationDeptId")!="0") 
	    		where +=" AND department ='"+request.getParameter("ObservationDeptId")+"'";
        }
	    if(request.getParameter("Observationprocessid")!=null) {
	    	 where +=" AND process ='"+request.getParameter("Observationprocessid")+"'";
	    }
	    HttpSession session=request.getSession();
		if (!session.getAttribute("departmentTxt").equals("IT")) {
			where+=" AND isDeleted!=1";
		}

	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","rowId","projectName","processName","department_text", "function_text", "createdBy_txt", "observation", "impact"};
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
		    
			for (int j = 0; j < aColumns.length; j++) {System.out.println(search.get(j));
				if(search.get(j)!="" && search.get(j)!="null" && search.get(j)!=null)
					where +=" AND "+aColumns[j]+" like '%"+search.get(j)+"%'";
			}
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.observationlist where 1=1 "+where;		    
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
	    String sql = "SELECT * FROM propel_project.observationlist where 1=1 "+where;
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
				 arrayObj.put("observation", rs.getString("observation")==null?"":rs.getString("observation"));
				 arrayObj.put("projectId", rs.getString("projectId")==null?"":rs.getString("projectId"));
				 arrayObj.put("defectType", rs.getString("defectType")==null?"":rs.getString("defectType"));
				 arrayObj.put("process", rs.getString("process")==null?"":rs.getString("process"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("function1", rs.getString("function")==null?"":rs.getString("function"));
				 arrayObj.put("impact", rs.getString("impact")==null?"":rs.getString("impact"));
				 arrayObj.put("name", rs.getString("name")==null?"":rs.getString("name"));
				 arrayObj.put("projectName", rs.getString("projectName")==null?"":rs.getString("projectName"));
				 arrayObj.put("processName", rs.getString("processName")==null?"":rs.getString("processName"));
				 arrayObj.put("createdBy_txt", rs.getString("createdBy_txt")==null?"":rs.getString("createdBy_txt"));
				 arrayObj.put("department_text", rs.getString("department_text")==null?"":rs.getString("department_text"));
				 arrayObj.put("function_text", rs.getString("function_text")==null?"":rs.getString("function_text"));
				 arrayObj.put("defectType_text", rs.getString("defectType_text")==null?"":rs.getString("defectType_text"));
				 arrayObj.put("observation_ation","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Observation' data-content='"+rs.getString("observation")+"'></i>");
				 arrayObj.put("impact_ation","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Impact' data-content='"+rs.getString("impact")+"'></i>");
				 arrayObj.put("createdOn", rs.getString("createdOn")==null?"":rs.getString("createdOn"));
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
