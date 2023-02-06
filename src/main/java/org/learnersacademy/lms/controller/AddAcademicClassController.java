package org.learnersacademy.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;

/**
 * Servlet implementation class AddAcademicClassController
 */
public class AddAcademicClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcademicClassServiceImpl service=new AcademicClassServiceImpl();
		AcademicClass academicClass=new AcademicClass();
		academicClass.setName((String)request.getParameter("classname"));
		String s=(String)request.getParameter("classname");
		//System.out.println(academicClass);
		service.insert(academicClass);
		request.setAttribute("msg", "inserted successfully"+s);
		RequestDispatcher rd=request.getRequestDispatcher("addClass.jsp");
		rd.include(request, response);
	}

}
