package org.learnersacademy.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.Teacher;
import org.learnersacademy.lms.service.TeacherService;
import org.learnersacademy.lms.service.TeacherserviceImpl;

/**
 * Servlet implementation class AddTeacherController
 */
public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherService service=new TeacherserviceImpl();
		Teacher teacher=new Teacher();
		teacher.setFirstName((String) request.getParameter("firstname"));
		teacher.setLastName((String) request.getParameter("lastname"));
		teacher.setDesignation((String) request.getParameter("designation"));
		teacher.setContactNo(Long.parseLong(request.getParameter("contact")));
		service.insert(teacher);		
		request.setAttribute("msg", "inserted successfully");
		RequestDispatcher rd=request.getRequestDispatcher("addTeacher.jsp");
		rd.include(request, response);
		
	}

}
