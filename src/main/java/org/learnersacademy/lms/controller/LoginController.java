package org.learnersacademy.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.learnersacademy.lms.entities.User;
import org.learnersacademy.lms.service.UserService;
import org.learnersacademy.lms.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
UserService service=new UserServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		User user=service.getUser(uname, pwd);
		if(user!=null && user.getUserType().equalsIgnoreCase("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
		else {
			request.setAttribute("msg", "Invalid Username or Password");
			//response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			//out.print("<p style=color:red>Invalid username/password..</p>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
		}
	}

}
