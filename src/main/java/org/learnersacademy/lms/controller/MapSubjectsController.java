package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.AcademicClassDao;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl;
import org.learnersacademy.lms.dao.SubjectDaoImpl;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.service.AcademicClassService;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;
import org.learnersacademy.lms.service.SubjectServiceImpl;

/**
 * Servlet implementation class MapSubjectsController
 */
public class MapSubjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MapSubjectsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		AcademicClassServiceImpl service=new AcademicClassServiceImpl();
		SubjectServiceImpl subService=new SubjectServiceImpl();
		List<AcademicClass> classes=service.getAll();
		List<Subject> subjects=subService.getAll();
		for(Subject sub:subjects)
		{
			out.print(sub.getName());
		}
		request.setAttribute("classes", classes);
		request.setAttribute("subjects", subjects);
		RequestDispatcher rd=request.getRequestDispatcher("mapSubjectToClass.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	AcademicClassService service=new AcademicClassServiceImpl();
	SubjectServiceImpl serviceSub=new SubjectServiceImpl();
	int cId=Integer.parseInt(request.getParameter("className"));
	int sId=Integer.parseInt(request.getParameter("subjectName"));
			
	AcademicClass cls=service.findByClassId(cId);
	Subject sub=serviceSub.getSubject(sId);	
	sub.addAcademicClass(cls);
	//service.update(cls);
	int success=serviceSub.update(sub);
	if(success==-1)
		response.getWriter().println("This subject is already assigned to the "+cls.getName());
	else if(success==-2)
		response.getWriter().println("Unexpected problem occured in assigning the subject.Check if this subject is already assigned the "+cls.getName());
	else if(success==1)
		response.getWriter().println("This subjects is assigned successfully");
		
	}

}
