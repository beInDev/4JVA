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
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register Servlet Requested.");
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/profile.jsp"); 
	    reqDispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String register_fname = (String)request.getAttribute("register_fname");
		String register_lname = (String)request.getAttribute("register_lname");
		String register_email = (String)request.getAttribute("register_email");
		String register_postal = (String)request.getAttribute("register_postal");
		String register_username = (String)request.getAttribute("register_username");
		String register_password = (String)request.getAttribute("register_password");
		String register_password_bis = (String)request.getAttribute("register_password_bis");
		
		if(register_fname != null && !register_fname.isEmpty() &&
				register_lname != null  && !register_lname.isEmpty() &&
				register_email != null  && !register_email.isEmpty() &&
				register_postal != null  && !register_postal.isEmpty() &&
				register_username != null  && !register_username.isEmpty() &&
				register_password != null  && !register_password.isEmpty() &&
				register_password_bis != null  && !register_password_bis.isEmpty())
		{
			if(!register_password.equals(register_password_bis))
			{
				request.setAttribute("error", true);
				doGet(request, response);
			}
			User user = (User)request.getSession().getAttribute("user");
			User u = new User();
			u.setFName(register_fname);
			u.setLName(register_lname);
			u.setEmail(register_email);
			u.setCodePostal(register_postal);
			u.setUserName(user.getUserName());
			u.setPassword(register_password);
			userDao.update(u);
			request.getSession().setAttribute("user", u);
			request.setAttribute("passed", true);
		}
		else
		{
			request.setAttribute("error", true);
		}
		doGet(request, response);
	}

}
