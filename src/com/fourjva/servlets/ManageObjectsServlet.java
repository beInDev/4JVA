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
import com.fourjva.entities.Item;
import com.fourjva.entities.User;

/**
 * Servlet implementation class MangerObjectsServlet
 */
@WebServlet("/myobjects")
public class ManageObjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ItemDao itemDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageObjectsServlet() {
        super();
        if(itemDao == null)
        	itemDao = new ItemDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Manage Objects Servlet Requested.");
		if(request.getSession().getAttribute("user") != null)
		{
			if(request.getParameter("delete") != null) {
				Item item = itemDao.findById(Long.parseLong(request.getParameter("delete")));
				itemDao.remove(item);
				request.setAttribute("removed", true);
			}
			User u = (User)request.getSession().getAttribute("user");
			List<Item> items = itemDao.getUserItems(u);
			request.setAttribute("items", items);
		} else {
			response.sendRedirect("/login");
		}
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/myObjects.jsp"); 
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
			i.setPrice(Double.parseDouble(create_price));
			i.setType(create_type);
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
