package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.entities.Teacher;
import org.learnersacademy.lms.service.StudentService;
import org.learnersacademy.lms.service.StudentServiceImpl;
import org.learnersacademy.lms.service.TeacherService;
import org.learnersacademy.lms.service.TeacherserviceImpl;

/**
 * Servlet implementation class TeacherReportController
 */
public class TeacherReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		TeacherService service = new TeacherserviceImpl();
		//SubjectServiceImpl subService = new SubjectServiceImpl();
		List<Teacher> teachers = service.getAll();
		Set<Subject> s = new HashSet<>();
		//Set<Subject> s = new HashSet<>();
		//Set<Student> stu = new HashSet<>();
		// out.println("<table>");
		// PrintWriter out = response.getWriter();
		if(teachers!=null)
		{
		out.println("<html><style>\r\n" + "body {background-color:lightblue; text-align:left;}\r\n"
				+ "h1 {color:blue; font-size:40px; }\r\n" + "p {font-family:verdana; font-size:20px;}\r\n"
				+ "table, th, td {font-size:20px; border: 1px solid black;}\r\n"
				+ "th {font-size:20px;background-color:yellow; border: 1px solid black;}\r\n" + "</style>\r\n"
				+ "<body>");
		out.println("<h1>Report of Teachers</h1>");
		//out.println("</body></html>");
		out.println("<table><tr><th>FirstName</th><th>LastName</th><th>Designation</th><th>Contact</th><th>Subjects</th></tr>");
		for (Teacher teacher : teachers) {
			// out.println(c.getName());
			//out.println("<tr><td>" + stu.getFirstName() + "</td>");
			out.println("<tr><td>" + teacher.getFirstName() + "</td>");
			out.println("<td>" + teacher.getLastName() + "</td>");
			out.println("<td>" + teacher.getDesignation() + "</td>");
			out.println("<td>" + teacher.getContactNo() + "</td>");
			if (!teacher.getSubjects().isEmpty()) {
				s = teacher.getSubjects();
			}
			out.println("<td><p>");
			for (Subject s1 : s) {
				out.println("<p>" + s1.getName() + "</p>");
			}
			out.println("</p></td>");
			//out.println("<td>"+teacher.getSubjects()+"</td>");
			
			}
		out.println("</tr></table>");
		out.println("</body></html>");
		}
		else
		{
			out.println("There is no teacher available");
		}


	}

}
