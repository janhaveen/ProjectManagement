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

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class GetFunctionTabs
 */
@WebServlet("/GetFunctionTabs")
public class GetFunctionTabs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        conn= MySqlConnect.DBConnection();
        String sql = "SELECT * FROM propel_legend.projectlegendlist where 1=1 ";
        if(request.getParameter("DepartmentId")!=null) {
        	sql+=" AND subCategory='"+request.getParameter("DepartmentId")+"'";
		}
        sql+=" AND legendGroup='Function'";
        String str="";
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				str+="<li class='nav-item' id='li"+rs.getString("rowid")+"' >"
        			+ "<a class='nav-link' id='a"+rs.getString("rowid")+"' data-toggle='tab' role='tab'>"+rs.getString("description")
        			+ "</a></li>";
			}
			str+="<button class='btn btn-primary' onclick='loadBlankformForFunction();'>"+
				 "<i class='fa fa-plus mr-1'></i> Add New</button>";
			out.println(str);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            out.close();  // Always close the output writer
        }
	}
}
