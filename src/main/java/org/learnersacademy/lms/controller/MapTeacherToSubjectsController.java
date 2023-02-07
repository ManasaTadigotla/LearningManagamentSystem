package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.entities.Teacher;
import org.learnersacademy.lms.service.AcademicClassService;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;
import org.learnersacademy.lms.service.SubjectServiceImpl;
import org.learnersacademy.lms.service.TeacherService;
import org.learnersacademy.lms.service.TeacherserviceImpl;

/**
 * Servlet implementation class MapTeacherToSubjectsController
 */
public class MapTeacherToSubjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MapTeacherToSubjectsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		TeacherService service = new TeacherserviceImpl();
		SubjectServiceImpl subService = new SubjectServiceImpl();
		List<Teacher> teachers = service.getAll();
		List<Subject> subjects = subService.getAll();
		if (teachers.isEmpty() || subjects.isEmpty()) {
			if (teachers.isEmpty())
			{	
				out.println("No Teacher available");
				//request.setAttribute("msg", "There is no teacher available");
				//RequestDispatcher rd = request.getRequestDispatcher("mapTeacherToSubject.jsp");
				//rd.include(request, response);
			}				
			if (subjects.isEmpty())
				out.println("No subject available");
		} else {
			request.setAttribute("teachers", teachers);
			request.setAttribute("subjects", subjects);
			RequestDispatcher rd = request.getRequestDispatcher("mapTeacherToSubject.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherService service = new TeacherserviceImpl();
		SubjectServiceImpl serviceSub = new SubjectServiceImpl();
		int tId = Integer.parseInt(request.getParameter("teacherType"));
		int sId = Integer.parseInt(request.getParameter("subjectType"));
		Teacher teacher = service.getTeacher(tId);
		Subject sub = serviceSub.getSubject(sId);
		sub.addTeacher(teacher);
		int success= serviceSub.update(sub);
		if(success==-1)
			response.getWriter().println("This subject is already assigned to the "+teacher.getFirstName());
		else if(success==-2)
			response.getWriter().println("Unexpected problem occured in assigning the subject.Check if this subject is already assigned the "+teacher.getFirstName());
		else if(success==1)
			response.getWriter().println("This subject is assigned successfully");
		
	}

}
