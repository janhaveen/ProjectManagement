package com.project.topdown;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeDepartment
 */
@WebServlet("/ChangeDepartment")
public class ChangeDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		DepartmentFunction f=new DepartmentFunction();
		f.setFunctionId(request.getParameter("fid"));
		f.setDepartmentId(request.getParameter("deptid"));
		if(f.change_dept()) {
			out.println("1");
		}else {
			out.println("10");
		}
	}

}
