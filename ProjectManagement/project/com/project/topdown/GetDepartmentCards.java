package com.project.topdown;

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

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class GetDepartmentCards
 */
@WebServlet("/GetDepartmentCards")
public class GetDepartmentCards extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        conn= MySqlConnect.DBConnection();
        HttpSession session = request.getSession();
        String sql = "SELECT * FROM propel_legend.projectlegendlist where 1=1 ";
        if(request.getParameter("ProjectId")!=null) {
        	sql+=" AND ProjectId='"+request.getParameter("ProjectId")+"'";
		}
        if (!session.getAttribute("departmentTxt").equals("IT")) {
			sql+=" AND isDeleted!=1";
		}
        sql+=" AND legendGroup='Department'";
        String deptDiv="", outstr="";
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				deptDiv=""+getFunctionCards(rs.getString("rowId"), session.getAttribute("departmentTxt").toString());
				outstr+="<div class='col-md-3' style='padding:15px'>" + 
					"<div class='card'>"+
					"<div class='card-header'>" 
					+"<div class='row'>"
					+"<div class='col-md-8' style='font-size:115%'>"+rs.getString("description") +"</div>"
					+"<div class='col-md-4'><i style='font-size:130%; padding:2px;' class='fa fa-pencil-alt  pull-right' onClick='EditDept( \"" + rs.getString("rowId") + "\", \""+rs.getString("description")+"\")'></i>"
					+" <i style='font-size:130%; padding:2px;' class='fa fa-trash-alt pull-right' onClick='DeleteDept(\"" +rs.getString("rowId")+"\")' aria-hidden='true'></i>"
					+"</div></div></div>" + 
					"<div class='card-body'>"+deptDiv+"     </div>" + 					
					"</div>" + 
					"</div>";
			}
			out.println(outstr);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            out.close();  // Always close the output writer
        }
	}
	
	private String getFunctionCards(String deptId, String UserDept) {
		String str="";
        conn= MySqlConnect.DBConnection();
        String sql = "SELECT * FROM propel_project.functionlist where 1=1 ";
        if(deptId != null) {
        	sql+=" AND departmentId='"+deptId+"'";
		}
        
		if (!UserDept.equals("IT")) {
			sql+=" AND isDeleted!=1";
		}
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				/*str+="<li class='list-group-item center' id='li"+rs.getString("rowId")+"' >"
					 +"<div class='row' style='margin-bottom: -14%;'>"
					 +"<div class='col-md-6'>"+rs.getString("name") +"</div>"
					 +"<div class='col-md-6'><i class='fa fa-pencil-alt  pull-right' onClick='EditFunction( \"" + rs.getString("rowId") + "\", \""+rs.getString("name")+"\", \""+rs.getString("roleDesc")+"\", \""+rs.getString("InfluencingFactor")+"\")'></i>"
					 +"  <i class='fa fa-trash-alt pull-right' onClick='DeleteFunction(\"" +rs.getString("rowId")+"\")' aria-hidden='true'></i>"
					 +"  <i class='fa fa-exchange-alt pull-right' onClick='changeDepartment(\""+rs.getString("rowId")+"\", \""+rs.getString("departmentId")+"\")' aria-hidden='true'></i>"
					+"</div></div></li>";*/
				/*str+="<li class='list-group-item ' id='li"+rs.getString("rowId")+"' >"
					  +rs.getString("name") +" <i class='fa fa-info-circle  pull-right' onClick='viewFn( \"" + rs.getString("rowId") + "\")'></i>"
					  +"</li>";*/
				str+="" + 
					 "<a>"+rs.getString("name")+
					 "<i class='fas fa-info-circle' style='padding: 0px 10px;' data-toggle='modal' onClick='viewFn( \"" + rs.getString("rowId") + "\")'></i>"+ 
					 "</a><br>"+ 
					 "";
				
			}
			/*str+="<button class='btn btn-primary' onclick='loadBlankformForFunction("+deptId+");'>"+
				 "<i class='fa fa-plus mr-1'></i> Add New</button>";*/
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //conn.close();  // Always close the output writer
        }
        return str;
	}
}
