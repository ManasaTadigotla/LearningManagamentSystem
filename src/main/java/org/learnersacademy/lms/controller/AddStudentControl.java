package org.learnersacademy.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.service.StudentService;
import org.learnersacademy.lms.service.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentControl
 */
public class AddStudentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service=new StudentServiceImpl();
		Student student=new Student();
		student.setFirstName((String) request.getParameter("firstname"));
		student.setLastName((String) request.getParameter("lastname"));
		student.setAddress((String) request.getParameter("address"));
		student.setContactNo(Long.parseLong(request.getParameter("contactno")));
		student.setEmail((String)request.getParameter("email"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		service.insert(student);		
		request.setAttribute("msg", "inserted successfully");
		RequestDispatcher rd=request.getRequestDispatcher("addStudent.jsp");
		rd.include(request, response);
		
	}

}
