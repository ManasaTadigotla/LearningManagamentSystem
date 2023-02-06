package org.learnersacademy.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.service.SubjectService;
import org.learnersacademy.lms.service.SubjectServiceImpl;

/**
 * Servlet implementation class AddSubjectController
 */
public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSubjectController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectService service = new SubjectServiceImpl();
		Subject sub = new Subject();
		String name = request.getParameter("name");
		if (!name.isBlank()) {
			sub.setName(name);
			try {
				int status = (int) service.insert(sub);
				if (status == 1) {
					request.setAttribute("msg", "Inserted successfully");
					RequestDispatcher rd = request.getRequestDispatcher("addSubject.jsp");
					rd.include(request, response);
				} else if (status == -1) {
					request.setAttribute("msg", "This Subject is already added");
					RequestDispatcher rd = request.getRequestDispatcher("addSubject.jsp");
					rd.include(request, response);
				}
			} catch (Exception e) {
				// e.printStackTrace();
				response.getWriter().println("oops! Something went wrong");
			}
		} else {
			request.setAttribute("msg", "Plz enter subject name");
			RequestDispatcher rd = request.getRequestDispatcher("addSubject.jsp");
			rd.include(request, response);
		}
	}

}
