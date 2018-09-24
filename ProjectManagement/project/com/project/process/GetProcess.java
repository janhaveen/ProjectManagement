package com.project.process;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class GetProcess
 */
@WebServlet("/GetProcess")
public class GetProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    PreparedStatement stmt = null;
    JSONArray jArray = new JSONArray();
	private String str;
	private int i;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    conn= MySqlConnect.DBConnection();
	    int k = 0; i=1;
	    String where="";
	    if(request.getParameter("interviewid")!=null) {
	    	where +=" AND interviewId ='"+request.getParameter("interviewid")+"'";
        }
	    if(request.getParameter("projectid")!=null) {
	    	where +=" AND projectId ='"+request.getParameter("projectid")+"'";
        }
	    if(request.getParameter("department")!=null) {
	    	where +=" AND department ='"+request.getParameter("department")+"'";
        }if(request.getParameter("processid")!=null) {
	    	where +=" AND rowId ='"+request.getParameter("processid")+"'";
        }
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","rowId","procedureName","dept_text","observationCount","type", "description"};
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
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.interviewprocesslist where 1=1 "+where;		    
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
	    String sql = "SELECT * FROM propel_project.interviewprocesslist where 1=1 "+where;
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
				 arrayObj.put("processName", rs.getString("procedureName")==null?"":rs.getString("procedureName"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("dept_text", rs.getString("dept_text")==null?"":rs.getString("dept_text"));
				 arrayObj.put("function1", rs.getString("function")==null?"":rs.getString("function"));
				 arrayObj.put("type", rs.getString("type")==null?"":rs.getString("type"));
				 arrayObj.put("observationCount", rs.getString("observationCount")==null?"":rs.getString("observationCount"));
				 arrayObj.put("description", rs.getString("comments")==null?"":rs.getString("comments"));
				 arrayObj.put("description_ation","<i class='fa fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Description' data-content='"+rs.getString("comments")+"'></i>");
				 
				 arrayObj.put("supplier_action","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Supplier' data-content='"+rs.getString("supplier")+"'></i>");
				 arrayObj.put("input_action","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Input' data-content='"+rs.getString("input")+"'></i>");
				 arrayObj.put("process_action","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Process' data-content='"+rs.getString("process")+"'></i>");
				 arrayObj.put("output_action","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Output' data-content='"+rs.getString("output")+"'></i>");
				 arrayObj.put("customer_action","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Customer' data-content='"+rs.getString("customer")+"'></i>");

				 
				 arrayObj.put("supplier", rs.getString("supplier")==null?"":rs.getString("supplier"));
				 arrayObj.put("input", rs.getString("input")==null?"":rs.getString("input"));
				 arrayObj.put("output", rs.getString("output")==null?"":rs.getString("output"));
				 arrayObj.put("customer", rs.getString("customer")==null?"":rs.getString("customer"));
				 arrayObj.put("process", rs.getString("process")==null?"":rs.getString("process"));
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
			response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        conn=MySqlConnect.DBConnection();
	        String sql="SELECT * FROM propel_project.interviewprocesslist where 1=1 ";
	        if(request.getParameter("interviewid")!=null) {
	        	sql +=" AND interviewId ='"+request.getParameter("interviewid")+"'";
	        }
	        str="";
	        try {
	        	stmt=conn.prepareStatement(sql);
	        	ResultSet rs=stmt.executeQuery(sql);
	        	str="<a class='btn-floating btn-sm peach-gradient'  onclick='newProcess()'><i class='fas fa-plus'></i></a>";
	        	while(rs.next()) {
	        		str+="<div class='chip lighten-4'>" + 
	        			"<span class='black-text'>"+rs.getString("processName")+"  </span>" + 
	        			"<i class='edit fas fa-pencil-alt' "
	        			+ "onclick='EditProcess(\""+rs.getString("rowId")+"\",\""+rs.getString("processName")+"\",\""+rs.getString("description")+"\","
	        			+ " \""+rs.getString("dept_text")+"\",\""+rs.getString("function_text")+"\", \""+rs.getString("department")+"\",\""+rs.getString("function")+"\");'></i>" + 
	        			/*"<i class='close fas fa-times'></i>" + */
	        			"</div>";
	        	}
	        	out.println(str);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            out.close();  // Always close tde output writer
	        }
	}

}
