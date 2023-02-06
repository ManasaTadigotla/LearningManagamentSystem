package org.learnersacademy.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.learnersacademy.lms.entities.User;
import org.learnersacademy.lms.service.UserService;
import org.learnersacademy.lms.service.UserServiceImpl;

/**
 * Servlet implementation class ChangePasswordCotroller
 */
public class ChangePasswordCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldGivenPwd=(String) request.getParameter("oldPwd");
		String newPwd=(String) request.getParameter("newPwd");
		//String oldGivenPwd=(String) request.getParameter("oldPwd");
		User user= (User)request.getSession().getAttribute("user");
		RequestDispatcher rd;
		if(user!=null)
		{
		String uName=user.getUserName();
		UserService userService=new UserServiceImpl();
		if(oldGivenPwd!=null && newPwd!=null)
		{
			if(oldGivenPwd!=newPwd)
			{
				int state=userService.updatePassword(uName, oldGivenPwd, newPwd);
				if(state==1)
				{
					request.setAttribute("msg", "Password changed successfully");	
					rd=request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}
				else
				{
					request.setAttribute("msg", "oops! Some thing went wrong.Plz try again..");	
					rd=request.getRequestDispatcher("changePwd.jsp");
					rd.include(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "old and new password should not be the same");
				rd=request.getRequestDispatcher("changePwd.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Plz enter old and new passwords");
			rd=request.getRequestDispatcher("changePwd.jsp");
			rd.include(request, response);
		}
		
		}
		else
		{
			request.setAttribute("msg", "Invalid user");
			rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
		//rd.include(request, response);
		//String oldPwd=user.get
	}

}
