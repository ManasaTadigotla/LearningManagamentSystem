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

import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.service.AcademicClassServiceImpl;
import org.learnersacademy.lms.service.StudentService;
import org.learnersacademy.lms.service.StudentServiceImpl;
import org.learnersacademy.lms.service.SubjectServiceImpl;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StudentService service = new StudentServiceImpl();
		//SubjectServiceImpl subService = new SubjectServiceImpl();
		List<Student> students = service.getAll();
		//Set<Subject> s = new HashSet<>();
		//Set<Student> stu = new HashSet<>();
		// out.println("<table>");
		// PrintWriter out = response.getWriter();
		if(students!=null)
		{
		out.println("<html><style>\r\n" + "body {background-color:lightblue; text-align:left;}\r\n"
				+ "h1 {color:blue; font-size:40px; }\r\n" + "p {font-family:verdana; font-size:20px;}\r\n"
				+ "table, th, td {font-size:20px; border: 1px solid black;}\r\n"
				+ "th {font-size:20px;background-color:yellow; border: 1px solid black;}\r\n" + "</style>\r\n"
				+ "<body>");
		out.println("<h1>Report of Students</h1>");
		//out.println("</body></html>");
		out.println("<table><tr><th>FirstName</th><th>LastName</th><th>Age</th><th>Address</th><th>Email</th><th>Class</th></tr>");
		for (Student stu : students) {
			// out.println(c.getName());
			//out.println("<tr><td>" + stu.getFirstName() + "</td>");
			out.println("<tr><td>" + stu.getFirstName() + "</td>");
			out.println("<td>" + stu.getLastName() + "</td>");
			out.println("<td>" + stu.getAge() + "</td>");
			out.println("<td>" + stu.getAddress() + "</td>");
			out.println("<td>" + stu.getEmail() + "</td>");
			out.println("<td>"+stu.getAcademicClass().getName()+"</td>");			
			}
		out.println("</tr></table>");
		out.println("</body></html>");
		}
		else
		{
			out.println("There is no student enrolled");
		}

	}

}
