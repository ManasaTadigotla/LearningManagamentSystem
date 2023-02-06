package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.service.AcademicClassService;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;
import org.learnersacademy.lms.service.StudentService;
import org.learnersacademy.lms.service.StudentServiceImpl;
import org.learnersacademy.lms.service.SubjectServiceImpl;

/**
 * Servlet implementation class MapController
 */
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		AcademicClassService service=new AcademicClassServiceImpl();
		StudentService stuService=new StudentServiceImpl();
		List<AcademicClass> classes=service.getAll();
		List<Student> students=stuService.getAll();
		if(classes!=null)
		{
		if(students!=null)
		{		
		req.setAttribute("classes", classes);
		req.setAttribute("students", students);
		RequestDispatcher rd=req.getRequestDispatcher("mapStudentToClass.jsp");
		rd.forward(req, resp);
		}
		else
		{
			out.print("There is no student available to assign");
		}
		}
		else
		{
			out.print("There is no class added");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AcademicClassService service=new AcademicClassServiceImpl();
		StudentService serviceStu=new StudentServiceImpl();
		int cId=Integer.parseInt(request.getParameter("classType"));
		int studentId=Integer.parseInt(request.getParameter("studentType"));
		//response.getWriter().print(studentId);
			
		AcademicClass cls=service.findByClassId(cId);
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Student> query=session.createQuery("select s from org.learnersacademy.lms.entities.Student s where s.studentId="+studentId,Student.class);
		//query.setParameter(1, cId);
		Student stu=query.getSingleResult();
		//session.close();
		
		//Student stu=serviceStu.findByStudentId(studentId);
		if(cls!=null)
		{
			if(stu!=null)
			{
				cls.addStudent(stu);
				
				//cls.getSubjects().add(sub);
				//sub.getClasses().add(cls);
				stu.addAcademicClassToStudent(cls);
				service.update(cls);
				serviceStu.update(stu);
			}
			else
			{
				response.getWriter().print("Sorry Some problem encountered in getting student details");
			}
		}
		else
		{
			response.getWriter().print("Sorry Some problem encountered in getting Class details");
		}
		
	}

}
