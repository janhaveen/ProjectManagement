package com.project.project;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/UpdateProject")
public class UpdateProject extends HttpServlet {
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
		p.setBillAmount(Float.parseFloat(request.getParameter("billAmt")));
		p.setPaymentMode(request.getParameter("modeOfPay"));
		p.setPaymentFrequency(request.getParameter("frequency"));
		p.setGstNo(request.getParameter("gst"));
		p.setAddress1(request.getParameter("address1"));
		p.setAddress2(request.getParameter("address2"));
		p.setAreaCity(request.getParameter("area"));
		p.setState(request.getParameter("state"));
		p.setPincode(request.getParameter("pincode"));
		try {
			p.setStartdate(MySqlConnect.convertToSqlDate(request.getParameter("startDate")));
		} catch (Exception e) {
			// TODO: handle exception
		}		
		p.setVisitfrequency(request.getParameter("visitFrequency"));
		p.setCpc(request.getParameter("cpc"));
		p.setEpc(request.getParameter("epc"));
		p.setCreatedby(session.getAttribute("userId").toString());
		if(p.updateProject()) {
			out.println("1");
		}else {
			out.println("0");
		}
	}
}
