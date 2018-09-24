package com.project.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.rtf.RTFEditorKit;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Project p=new Project();
 
		p.setProjectId(request.getParameter("Project ID"));
		p.setCompanyName(request.getParameter("companyName"));
		p.setBranchName(request.getParameter("Branch Name"));
		p.setReferenceBy(request.getParameter("referenceBy"));
		p.setLocation(request.getParameter("location"));
		p.setIndustry(request.getParameter("industry"));		
		p.setPhoneNo(request.getParameter("phoneNo"));
		p.setWebsite(request.getParameter("website"));
		p.setEmailId(request.getParameter("emailId"));
		p.setStakeholderFname(request.getParameter("firstName"));
		p.setStakeholderLname(request.getParameter("lastName"));
		p.setStakeholderDesignation(request.getParameter("designation"));		
		p.setStakeholderContactno((request.getParameter("mobileNo")));
		p.setStakeholderAltcontactno((request.getParameter("altContactNo")));
		p.setStakeholderEmailid(request.getParameter("SHEmailId"));
		try{
			p.setBillAmount(Float.parseFloat(request.getParameter("billAmt")));
		}catch (Exception e) {
			p.setBillAmount(Float.parseFloat("0"));
		}
		p.setPaymentMode(request.getParameter("modeOfPay"));
		p.setPaymentFrequency(request.getParameter("frequency"));
		p.setGstNo(request.getParameter("gst"));
		p.setAddress1(request.getParameter("address1"));
		p.setAddress2(request.getParameter("address2"));
		p.setAreaCity(request.getParameter("area"));
		p.setState(request.getParameter("state"));
		p.setPincode(request.getParameter("pincode"));
		p.setSource(request.getParameter("referenceBy"));
		p.setPreferredDay(request.getParameter("preferredDayText"));
		try {
			p.setStartdate(MySqlConnect.convertToSqlDate(request.getParameter("startDate")));
		} catch (Exception e) {
			// TODO: handle exception
		}		
		p.setVisitfrequency(request.getParameter("visitFrequency"));
		p.setCpc(request.getParameter("cpc"));
		p.setEpc(request.getParameter("epc"));
		p.setCreatedby(session.getAttribute("userId").toString());
		boolean resultVal=false;
		if(request.getParameter("action").equals("insert"))
			resultVal=p.saveProject();
		else
			resultVal=p.updateProject();
		if(resultVal) {
			out.println("1");
		}else {
			out.println("0");
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		HttpSession session=request.getSession();
		PreparedStatement stmt;
		String sql;
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_project where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_project SET isDeleted=1 where rowId ='"+ request.getParameter("id") +"'";
		}System.out.print(sql);
		try {
			
			stmt = conn.prepareStatement(sql);
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
			}
			
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
