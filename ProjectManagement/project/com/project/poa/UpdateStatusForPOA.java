package com.project.poa;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.system.GetSystemDetails;

/**
 * Servlet implementation class UpdateStatusForPOA
 */
@WebServlet("/UpdateStatusForPOA")
public class UpdateStatusForPOA extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		HttpSession session=request.getSession();
		Date date1 = new Date(System.currentTimeMillis());
		PlanOfAction poa=new PlanOfAction();			
		PlanOfActionLog poal=new PlanOfActionLog();
		poa.setPlanOfActionId(request.getParameter("planofactionId"));
		poa.setStatus(request.getParameter("statusPOA"));
		if(request.getParameter("statusPOA").equals("100005")) {
			poa.setClosureDate(date1);
			poa.update_closureDate();
		}
		if(request.getParameter("statusPOA")!=null || request.getParameter("statusPOAOld")!=null) {
			if(!request.getParameter("statusPOAOld").equals(request.getParameter("statusPOA"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200004");
				poal.setFromValue(request.getParameter("statusPOAOld"));
				poal.setToValue(request.getParameter("statusPOA"));
				//poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}
		}
		poa.setSystemMac(GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
		poa.setSystemIp(GetSystemDetails.getIp());
		poa.setSystemName(GetSystemDetails.getSystemName());
		poa.setCreatedBy(session.getAttribute("userId").toString());
		poa.update_status();
	}

}
