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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherService service = new TeacherserviceImpl();
		Teacher teacher = new Teacher();
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String desig = request.getParameter("designation");
		String contact = request.getParameter("contact");
		if (fName.isEmpty() || lName.isEmpty() || desig.isEmpty() || contact.isEmpty()) {
			response.getWriter().println("Plz provide all the details");
			// request.setAttribute("msg", "Plz provide all the details");
			// RequestDispatcher rd=request.getRequestDispatcher("addTeacher.jsp");
			// rd.include(request, response);
		} else {
			teacher.setFirstName(fName);
			teacher.setLastName(lName);
			teacher.setDesignation(desig);
			if (contact != null) {
				teacher.setContactNo(Long.parseLong(contact));
			}
			try {
				service.insert(teacher);
				request.setAttribute("msg", "inserted successfully");
				RequestDispatcher rd = request.getRequestDispatcher("addTeacher.jsp");
				rd.include(request, response);
			} catch (Exception e) {
				request.setAttribute("msg", "Oops!Something went wrong.Plz check if Firstname may already exists");
				RequestDispatcher rd = request.getRequestDispatcher("addTeacher.jsp");
				rd.include(request, response);
			}
		}
	}

}
