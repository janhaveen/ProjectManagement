package com.project.observations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

/**
 * Servlet implementation class CreateProcess
 */
@WebServlet("/CreateObservation")
public class CreateObservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Observations o=new Observations();
		o.setObservationId(request.getParameter("ObservationId"));
		o.setProjectId(request.getParameter("ProjectId"));
		o.setName(request.getParameter("ObservationText"));
		o.setObservation(request.getParameter("observation"));
		o.setDefectType(request.getParameter("defectType"));
		o.setProcess(request.getParameter("process"));
		o.setDepartment(request.getParameter("department"));
		o.setFunction(request.getParameter("function"));
		o.setImpact(request.getParameter("impact"));		
		o.setSystemMac(GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
		o.setSystemIp(GetSystemDetails.getIp());
		o.setSystemName(GetSystemDetails.getSystemName());
		o.setCreatedBy(session.getAttribute("userId").toString());
		
		if(o.save_observations(request.getParameter("action")))
			out.println("1");
		else
			out.println("0");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		String sql="";
		HttpSession session=request.getSession();
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_observations where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_observations SET isDeleted=1,"
		    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
		    		+ " where rowId ='"+ request.getParameter("id") +"'";
		}
		System.out.print(sql);
		try {
			stmt = conn.prepareStatement(sql);
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
			}
			conn.close();
		}catch (SQLException e) {
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
