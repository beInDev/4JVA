package com.fourjva.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ListServlet
 */
@WebServlet("/browse")
public class ListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ItemDao itemDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItemServlet() {
        super();
        if(itemDao == null)
        	itemDao = new ItemDao();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("List Item Servlet Requested.");
		List<Item> items = itemDao.getLatestItems();
		request.setAttribute("items", items);
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/browseObjects.jsp"); 
	    reqDispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
