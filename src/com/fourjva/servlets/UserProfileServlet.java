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
import com.fourjva.entities.Item;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ItemDao itemDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        if(itemDao == null)
        	itemDao = new ItemDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register Servlet Requested.");
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/profile.jsp"); 
	    reqDispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String create_title = (String)request.getAttribute("create_title");
		String create_description = (String)request.getAttribute("create_description");
		String create_type = (String)request.getAttribute("create_type");
		String create_price = (String)request.getAttribute("create_price");
		String create_imageUrl = (String)request.getAttribute("create_imageUrl");		
		if(create_title != null && !create_title.isEmpty() &&
				create_description != null  && !create_description.isEmpty() &&
				create_type != null  && !create_type.isEmpty() &&
				create_price != null  && !create_price.isEmpty() &&
				create_imageUrl != null  && !create_imageUrl.isEmpty())
		{
			Item i = new Item();
			i.setTitle(create_title);
			i.setDescription(create_description);
			i.setType(create_type);
			i.setPrice(Double.parseDouble(create_price));
			i.setImageURL(create_imageUrl);
			itemDao.persist(i);
			request.setAttribute("passed", true);
		}
		else
		{
			request.setAttribute("error", true);
		}
		doGet(request, response);
	}

}
