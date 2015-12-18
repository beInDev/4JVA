package com.fourjva.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fourjva.dao.UserDao;
import com.fourjva.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserDao userDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        if(userDao == null)
        	userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet Requested.");
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/login.jsp"); 
	    reqDispatcher.forward(request,response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login_username = (String)request.getAttribute("login_username");
		String login_password = (String)request.getAttribute("login_password");
		
		if(login_username != null && !login_username.isEmpty() &&
				login_password != null  && !login_password.isEmpty())
		{
			User u = userDao.getUserByUsername(login_username);
			if(u.getPassword().equals(login_password))
			{
				request.getSession().setAttribute("user", u);
				request.setAttribute("passed", true);
			} else {
				request.setAttribute("error", true);
			}
			
		}
		else
		{
			request.setAttribute("error", true);
		}
		doGet(request, response);
	}

}
