package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.User;
import org.learnersacademy.lms.service.UserService;
import org.learnersacademy.lms.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static boolean isValidUserName(String uName) {
		String regex = "^[A-Za-z]\\w{4,10}$";

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

	public static boolean isValidPassword(String pwd) {
		String regex = "^[A-Za-z0-9]\\w{4,10}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (pwd == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(pwd);

		// Return if the username
		// matched the ReGex
		return m.matches();
	}

	public static boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (email == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(email);

		// Return if the username
		// matched the ReGex
		return m.matches();
	}

	UserService service = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();

		String uName = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		RequestDispatcher rd;

		if (isValidUserName(uName) && isValidPassword(pwd) && isValidEmail(email)) {
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setUserType(request.getParameter("usertype"));
			int userExist=service.findUserByUserName(uName);
			if (userExist == 0) {
				service.add(user);
				request.setAttribute("msg", user.getUserName() + " registered successfully");
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else if(userExist==1) {
				request.setAttribute("msg", "UserName already exists.plz try with other");
				rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
			else if(userExist==-1)
			{
				request.setAttribute("msg", "Something went wrong.plz try again");
				rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
		} else if (!isValidUserName(uName)) {
			request.setAttribute("msg", "Plz provide proper UserName");
			rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		} else if (!isValidPassword(pwd)) {
			request.setAttribute("msg", "Plz provide proper password");
			rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		} else if (!isValidEmail(email)) {
			request.setAttribute("msg", "Plz provide proper Email");
			rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}

	}

}
