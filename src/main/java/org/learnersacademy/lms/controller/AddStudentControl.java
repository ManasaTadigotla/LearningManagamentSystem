package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
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

	public static boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		if (email == null) {
			return false;
		}
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isValidUserName(String uName) {
		String regex = "^[A-Za-z]\\w{2,10}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (uName == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(uName);

		// Return if the username
		// matched the ReGex
		return m.matches();
	}

	public static boolean isValidContact(String cont) {
		String regex = "^[0-9]{10}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (cont == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(cont);

		// Return if the username
		// matched the ReGex
		return m.matches();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		Student student = new Student();
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String address = request.getParameter("address");
		String contact = request.getParameter("contactno");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		if (fName.isEmpty() || lName.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty()
				|| age.isEmpty()) {
			response.getWriter().println("Plz provide all the details");
		} else {
			try {
				if (isValidEmail(email) && isValidUserName(fName) && isValidContact(contact)) {
					student.setFirstName(fName);
					student.setLastName(lName);
					student.setAddress(address);
					student.setContactNo(Long.parseLong(contact));
					student.setEmail(email);
					student.setAge(Integer.parseInt(age));
					int success= service.insert(student);
					if(success==-1)
					{
						response.getWriter().println("Student with the same FirstName is already exist");
					}
					else
					{
					request.setAttribute("msg", "Inserted successfully");
					RequestDispatcher rd = request.getRequestDispatcher("addStudent.jsp");
					rd.include(request, response);
					}
				} else {
					response.getWriter().println("Please check FirstName, Email and Contact properly");
				}
			} catch (Exception e) {
				response.getWriter().println("OOps! Something went wrong");
				//e.printStackTrace();
			}

		}
	}

}
