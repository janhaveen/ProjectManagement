package com.project.poa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlBody;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;
import com.mysql.jdbc.StringUtils;

@WebServlet("/GetPlanOfActionList")
public class GetPlanOfActionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    PreparedStatement stmt = null;
    JSONArray jArray = new JSONArray();
	private int i;
	@SuppressWarnings("deprecation")
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
	    if(request.getParameter("projectid")!=null) {
	    	where +=" AND projectid ='"+request.getParameter("projectid")+"'";
        }
	    if(request.getParameter("statusId")!=null) {
	    	where +=" AND status ='"+request.getParameter("statusId")+"'";
	    }
	    if(request.getParameter("POAID")!=null) {
	    	where +=" AND rowId ='"+request.getParameter("POAID")+"'";
	    }
	    HttpSession session=request.getSession();
		if (!session.getAttribute("departmentTxt").equals("IT")) {
			where+=" AND isDeleted!=1";
		}
	    if(request.getParameter("viewOnly")!=null) {
	    	if(request.getParameter("viewOnly").equals("m"))
	    		where +=" AND cpc='"+session.getAttribute("userId")+"'";
	    	else 
	    		where +=" AND reportTo='"+session.getAttribute("userId")+"'";
	    }

	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","rowId","createdBy_txt","reviewDate","challenges1", "planofaction1", "status_txt", "comment1", "expectedClosureDate","closureDate"};
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
	   
		    String sql1 = "SELECT count(*) as total FROM propel_project.planofactionlist where 1=1 "+where;		    
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
	    String sql = "SELECT * FROM propel_project.planofactionlist where 1=1 "+where;
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
				 arrayObj.put("rowId",rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("reviewDate",rs.getString("reviewDate")==null?"":rs.getString("reviewDate"));
				 arrayObj.put("reviewDate1",rs.getString("reviewDate1")==null?"":rs.getString("reviewDate1"));
				 arrayObj.put("reviewee",rs.getString("reviewee")==null?"":rs.getString("reviewee"));
				 arrayObj.put("reviewee_txt",rs.getString("reviewee_txt")==null?"":rs.getString("reviewee_txt"));
				 arrayObj.put("challenges1",rs.getString("challenges")==null?"":rs.getString("challenges"));
				 arrayObj.put("planofaction1",rs.getString("planofaction")==null?"":rs.getString("planofaction"));
				 arrayObj.put("responsible",rs.getString("responsible")==null?"":rs.getString("responsible"));
				 arrayObj.put("accountable",rs.getString("accountable")==null?"":rs.getString("accountable"));
				 arrayObj.put("consulted",rs.getString("consulted")==null?"":rs.getString("consulted"));
				 arrayObj.put("informed",rs.getString("informed")==null?"":rs.getString("informed"));
				 arrayObj.put("status",rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("status_txt",rs.getString("status_txt")==null?"":rs.getString("status_txt"));
				 arrayObj.put("comment1",rs.getString("comment")==null?"":rs.getString("comment"));
				 arrayObj.put("expectedClosureDate",rs.getString("expectedClosureDate")==null?"":rs.getString("expectedClosureDate"));
				 arrayObj.put("expectedClosureDate1",rs.getString("expectedClosureDate1")==null?"":rs.getString("expectedClosureDate1"));
				 arrayObj.put("closureDate",rs.getString("closureDate")==null?"":rs.getString("closureDate"));
				 arrayObj.put("createdBy",rs.getString("createdBy")==null?"":rs.getString("createdBy"));
				 arrayObj.put("createdBy_txt",rs.getString("createdBy_txt")==null?"":rs.getString("createdBy_txt"));
				 arrayObj.put("updatedOn",rs.getString("updatedOn")==null?"":rs.getString("updatedOn"));
				 arrayObj.put("updatedBy_txt",rs.getString("updatedBy_txt")==null?"":rs.getString("updatedBy_txt"));
				 arrayObj.put("challenges","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Challenges' data-content=\""+StringEscapeUtils.escapeHtml4(rs.getString("challenges"))+"\"></i>");
				 arrayObj.put("planofaction","<i class=\"fas fa-2x fa-info-circle\" data-toggle=\"popover\" data-placement=\"top\" title=\"Plan Of Action\" data-content=\""+rs.getString("planofaction")+"\"></i>");
				 arrayObj.put("comment","<i class='fas fa-2x fa-info-circle' data-toggle='popover' data-placement='top' title='Comment' data-content='"+rs.getString("comment")+"'></i>");
				 arrayObj.put("priority_txt",rs.getString("priority_txt")==null?"":rs.getString("priority_txt"));
				 arrayObj.put("priority",rs.getString("priority")==null?"":rs.getString("priority"));
				 arrayObj.put("poaName",rs.getString("poaName")==null?"":rs.getString("poaName"));
				 arrayObj.put("StatusBtn",rs.getString("StatusBtn")==null?"":rs.getString("StatusBtn"));
				 arrayObj.put("companyName",rs.getString("companyName")==null?"":rs.getString("companyName"));
				 arrayObj.put("cpc_txt",rs.getString("cpc_txt")==null?"":rs.getString("cpc_txt"));
				 arrayObj.put("projectid",rs.getString("projectid")==null?"":rs.getString("projectid"));
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
