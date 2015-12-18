package com.fourjva.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fourjva.dao.ItemDao;
import com.fourjva.dao.UserDao;
import com.fourjva.entities.Item;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ItemDao itemDao;
	@EJB
	private UserDao userDao;
	
    public IndexServlet() {
        super();
        if(itemDao == null)
        	itemDao = new ItemDao();
        if(userDao == null)
        	userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Index servlet requested.");
		// Retrieving statistics.
		Long totalUsers = userDao.getRegisteredUsersNumber();
		Item lastObject = itemDao.getLastItem();
		Long totalObjects = itemDao.getTotalItemCount();
		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("lastObject", lastObject);
		request.setAttribute("totalObjects", totalObjects);
		// Forwarding index.jsp
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/index.jsp"); 
	    reqDispatcher.forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
