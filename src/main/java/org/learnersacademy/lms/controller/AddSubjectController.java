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
        super();        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectService service=new SubjectServiceImpl();
		Subject sub=new Subject();
		sub.setName(request.getParameter("name"));
		service.insert(sub);
		request.setAttribute("msg", "inserted successfully");
		RequestDispatcher rd=request.getRequestDispatcher("addSubject.jsp");
		rd.include(request, response);

	}

}
