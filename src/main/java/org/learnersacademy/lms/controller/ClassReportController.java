package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;
import org.learnersacademy.lms.service.SubjectServiceImpl;

/**
 * Servlet implementation class ClassReportController
 */
public class ClassReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassReportController() {
		super();
	}

	/**
	 * Display the Class name,subjects assigned to the class,students in that class.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AcademicClassServiceImpl service = new AcademicClassServiceImpl();
		SubjectServiceImpl subService = new SubjectServiceImpl();
	
		List<AcademicClass> classes = service.getAll();
		if(classes!=null)
		{
		Set<Subject> s = new HashSet<>();
		Set<Student> stu = new HashSet<>();
		// out.println("<table>");
		// PrintWriter out = response.getWriter();
		out.println("<html><style>\r\n" + "body {background-color:lightblue; text-align:left;}\r\n"
				+ "h1 {color:blue; font-size:40px; }\r\n" + "p {font-family:verdana; font-size:20px;}\r\n"
				+ "table, th, td {font-size:20px; border: 1px solid black;}\r\n"
				+ "th {font-size:20px;background-color:yellow; border: 1px solid black;}\r\n" + "</style>\r\n"
				+ "<body>");
		out.println("<h1>Report of Classes</h1>");
		out.println("</body></html>");
		out.println("<table><tr><th>ClassName</th><th>Assigned Subjects</th><th>Assigned Students</th></tr>");
		for (AcademicClass c : classes) {
			// out.println(c.getName());

			out.println("<tr><td>" + c.getName() + "</td>");
			// out.println("Subjects assigned");
			if (!c.getSubjects().isEmpty()) {
				s = c.getSubjects();
			}
			out.println("<td><p>");
			for (Subject s1 : s) {
				out.println("<p>" + s1.getName() + "</p>");
			}
			// out.println("Students enrolled");
			if (!c.getStudents().isEmpty()) {
				stu = c.getStudents();
			}
			out.println("<td><p>");
			for (Student st : stu) {
				out.println("<p>" + st.getFirstName() + "</p");
			}
			out.println("</p></td>");
		}
		out.println("</tr></table>");
		out.println("</body></html>");
		}
		else
		{
			out.println("There is no class enrolled");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
