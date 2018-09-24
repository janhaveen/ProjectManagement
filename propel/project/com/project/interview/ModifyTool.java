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
 * Servlet implementation class CreateProcess
 */
@WebServlet("/ModifyTool")
public class ModifyTool extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Tools t=new Tools();
		t.setToolId(request.getParameter("ToolId"));
		t.setProcessId(request.getParameter("ProcessId"));
		t.setInterviewId(request.getParameter("InterviewId"));
		t.setName(request.getParameter("withItemTitle"));
		t.setStorage(request.getParameter("storage"));
		t.setCondition(request.getParameter("condition"));
		t.setCaliberation(request.getParameter("calibration"));
		t.setMaintainance(request.getParameter("maintainance"));
		t.setCreatedBy(session.getAttribute("userId").toString());
		
		if(t.save_tools())
			out.println("1");
		else
			out.println("0");
	}

}
