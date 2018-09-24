package com.project.interview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyAudit
 */
@WebServlet("/ModifyAudit")
public class ModifyAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String type="";
		Audit a=new Audit();
		a.setAuditId(request.getParameter("AuditId"));
		a.setInterviewId(request.getParameter("InterviewId"));
		a.setInfluencingFactor(request.getParameter("InfluencingFactor"));
		a.setCurrentMetric(request.getParameter("auditMetricName"));
		a.setMetricType(request.getParameter("auditMetricType"));
		a.setComments(request.getParameter("auditItemComments"));
		a.setCreatedBy(session.getAttribute("userId").toString());
		type=request.getParameter("type")==""?"insert" : request.getParameter("type");
		if(a.saveAudit(type)) {
			out.println("1");
		}else {
			out.println("0");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
