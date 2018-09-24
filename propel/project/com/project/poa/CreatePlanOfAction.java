package com.project.poa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;
import com.project.observations.Observations;

/**
 * Servlet implementation class CreatePlanOfAction
 */
@WebServlet("/CreatePlanOfAction")
public class CreatePlanOfAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date d1=new Date(System.currentTimeMillis());
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis());
		PlanOfAction poa=new PlanOfAction();	
		PlanOfActionLog poal=new PlanOfActionLog();
		
		String responsible="",accountable="",consulted="",informed="";
		
		poa.setPlanOfActionId(request.getParameter("planofactionId"));
		poa.setReviewDate(timestamp);
		poa.setProjectid(request.getParameter("projectid"));
		poa.setReviewee(session.getAttribute("userId").toString());
		poa.setPoaName(request.getParameter("poaName"));
		poa.setChallenges(request.getParameter("challenges"));
		poa.setPlanofaction(request.getParameter("planofaction"));
		for(int i=0;i<Integer.parseInt(request.getParameter("countR"));i++) {
			responsible+=request.getParameter("responsible["+i+"]");
			if(i!=Integer.parseInt(request.getParameter("countR"))-1)
				responsible+=",";
		}
		poa.setResponsible(responsible);
		for(int i=0;i<Integer.parseInt(request.getParameter("countA"));i++) {
			accountable+=request.getParameter("accountable["+i+"]");
			if(i!=Integer.parseInt(request.getParameter("countA"))-1)
				accountable+=",";
		}
		poa.setAccountable(accountable);
		for(int i=0;i<Integer.parseInt(request.getParameter("countC"));i++) {
			consulted+=request.getParameter("consulted["+i+"]");
			if(i!=Integer.parseInt(request.getParameter("countC"))-1)
				consulted+=",";
		}
		poa.setConsulted(consulted);
		for(int i=0;i<Integer.parseInt(request.getParameter("countI"));i++) {
			informed+=request.getParameter("informed["+i+"]");
			if(i!=Integer.parseInt(request.getParameter("countI"))-1)
				informed+=",";
		}
		poa.setInformed(informed);
		
		poa.setComment(request.getParameter("comments"));
		try {
			poa.setExpectedClosureDate(MySqlConnect.convertToSqlDate(request.getParameter("ExpDateOfClosure")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(request.getParameter("statusPOA")!=null) {
			poa.setStatus(request.getParameter("statusPOA"));
			if(request.getParameter("statusPOA").equals("100005"))
				poa.setClosureDate(d1);
		}else {
			poa.setStatus("100001");
		}
		
		poa.setPriority(request.getParameter("priority"));
		poa.setSystemMac(GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
		poa.setSystemIp(GetSystemDetails.getIp());
		poa.setSystemName(GetSystemDetails.getSystemName());
		poa.setCreatedBy(session.getAttribute("userId").toString());
		
		
		if(request.getParameter("action").equals("insert")) {
			poal.setRowId(UUID.randomUUID().toString());
			poal.setAction("200001");
			poal.setFromValue("");
			poal.setToValue("");
			poal.setCreatedBy(session.getAttribute("userId").toString());
			logEntry = poal.save_PlanOfActionLog();
		}else {
			if(!request.getParameter("challengesOld").equals(request.getParameter("challenges"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200002");
				poal.setFromValue(request.getParameter("challengesOld"));
				poal.setToValue(request.getParameter("challenges"));
				poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}
			if(!request.getParameter("planofactionOld").equals(request.getParameter("planofaction"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200003");
				poal.setFromValue(request.getParameter("planofactionOld"));
				poal.setToValue(request.getParameter("planofaction"));
				poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}
			if(request.getParameter("statusPOA")!=null || request.getParameter("statusPOAOld")!=null) {
				if(!request.getParameter("statusPOAOld").equals(request.getParameter("statusPOA"))) {
					poal.setRowId(UUID.randomUUID().toString());
					poal.setPlanOfActionId(request.getParameter("planofactionId"));
					poal.setAction("200004");
					poal.setFromValue(request.getParameter("statusPOAOld"));
					poal.setToValue(request.getParameter("statusPOA"));
					poal.setComment(request.getParameter("comments"));
					poal.setCreatedBy(session.getAttribute("userId").toString());
					logEntry = poal.save_PlanOfActionLog();
				}
			}
			if(!request.getParameter("ExpDateOfClosure").equals(request.getParameter("ExpDateOfClosureOld"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200005");
				poal.setFromValue(request.getParameter("ExpDateOfClosureOld"));
				poal.setToValue(request.getParameter("ExpDateOfClosure"));
				poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}
			if(!request.getParameter("priority").equals(request.getParameter("priorityOld"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200007");
				poal.setFromValue(request.getParameter("priorityOld"));
				poal.setToValue(request.getParameter("priority"));
				poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}
			/*if(!request.getParameter("comments").equals(request.getParameter("commentsOld"))) {
				poal.setRowId(UUID.randomUUID().toString());
				poal.setPlanOfActionId(request.getParameter("planofactionId"));
				poal.setAction("200006");
				poal.setFromValue(request.getParameter("commentsOld"));
				poal.setToValue(request.getParameter("comments"));
				poal.setComment(request.getParameter("comments"));
				poal.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = poal.save_PlanOfActionLog();
			}*/
		}
		
		if(poa.save_poa(request.getParameter("action")))
			out.println("1");
		else
			out.println("0");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		HttpSession session=request.getSession();
		PreparedStatement stmt;
		String sql;
		if (session.getAttribute("departmentTxt").equals("IT")) {
			 sql = "DELETE FROM propel_project.d_poa where rowId ='"+ request.getParameter("id") +"'";
		}else {
		    sql = "UPDATE propel_project.d_poa SET isDeleted=1,"
		    		+ "updatedOn='"+timestamp+"', updatedBy='"+session.getAttribute("userId").toString()+"' "
		    		+ " where rowId ='"+ request.getParameter("id") +"'";
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
